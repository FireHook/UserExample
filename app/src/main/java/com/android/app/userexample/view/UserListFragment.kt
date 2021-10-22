package com.android.app.userexample.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.app.userexample.R
import com.android.app.userexample.databinding.FragmentUserListBinding
import com.android.app.userexample.view.base.BaseFragment
import com.android.app.userexample.view.entity.UserEntity
import com.android.app.userexample.view.recycler_adapter.UserListAdapter
import com.android.app.userexample.view_model.UserListViewModel
import com.android.app.userexample.view_model.base.Event
import com.android.app.userexample.view_model.factory.UserListViewModelFactory

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
class UserListFragment: BaseFragment<FragmentUserListBinding, UserListViewModel>(
    R.layout.fragment_user_list
), UserListAdapter.UserClickListener {

    private val viewModel: UserListViewModel by viewModels {
        UserListViewModelFactory(requireContext())
    }
    override fun getViewModelInstance() = viewModel

    private lateinit var userAdapter: UserListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        startObservingLiveData()
        viewModel.getUserEntityList()
    }

    private fun initViews() = with(binding) {
        with(recyclerView) {
            layoutManager = LinearLayoutManager(requireContext())
            itemAnimator = DefaultItemAnimator()
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
            adapter = UserListAdapter(this@UserListFragment).also {
                userAdapter = it
            }
        }

        sortByIdBtn.setOnClickListener {
            this@UserListFragment.viewModel.sortUsersById()
        }

        sortByUsernameBtn.setOnClickListener {
            this@UserListFragment.viewModel.sortUsersByUsername()
        }
    }

    private fun startObservingLiveData() {
        viewModel.userEntityList.observe(
            viewLifecycleOwner,
            ::onGetUserEntityList
        )
    }

    private fun onGetUserEntityList(event: Event<List<UserEntity>>) = with(binding) {
        event.getContentIfNotHandled()?.let {
            userAdapter.setAll(it)
        }
    }

    override fun onUserClicked(id: Int) {
        findNavController().navigate(
            UserListFragmentDirections.actionUserListFragmentToUserDetailFragment(id)
        )
    }

}