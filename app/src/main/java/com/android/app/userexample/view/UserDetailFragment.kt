package com.android.app.userexample.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.android.app.userexample.R
import com.android.app.userexample.databinding.FragmentUserDetailBinding
import com.android.app.userexample.longToast
import com.android.app.userexample.view.base.BaseFragment
import com.android.app.userexample.view.entity.UserDetailEntity
import com.android.app.userexample.view_model.UserDetailViewModel
import com.android.app.userexample.view_model.base.Event
import com.android.app.userexample.view_model.factory.UserDetailViewModelFactory

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
class UserDetailFragment: BaseFragment<FragmentUserDetailBinding, UserDetailViewModel>(
    R.layout.fragment_user_detail
) {

    private val viewModel: UserDetailViewModel by viewModels {
        UserDetailViewModelFactory(requireContext())
    }
    override fun getViewModelInstance() = viewModel

    private val args: UserDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startObservingLiveData()
        viewModel.getUsersDetails(args.userId)
    }

    private fun startObservingLiveData() = with(viewModel) {
        users.observe(
            viewLifecycleOwner,
            ::onGetUserDetail
        )
    }

    private fun onGetUserDetail(event: Event<UserDetailEntity>) = with(binding) {
        event.getContentIfNotHandled()?.let {
            nameTv.text = it.name
            usernameTv.text = it.userName
            addressTv.text = it.address
        }
    }

}