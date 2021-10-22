package com.android.app.userexample.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.android.app.userexample.longToast
import com.android.app.userexample.view_model.base.IBaseViewModel
import timber.log.Timber

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
abstract class BaseFragment<T : ViewDataBinding, VM : IBaseViewModel>(
    private val layout: Int
): Fragment() {

    protected lateinit var binding: T
    protected abstract fun getViewModelInstance(): VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layout, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getViewModelInstance().genericErrorMessage.observe(
            viewLifecycleOwner,
            {
                it?.let {
                    requireContext().longToast(it)
                }
            }
        )
    }

}