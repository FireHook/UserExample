package com.android.app.userexample.view_model.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
interface IBaseViewModel {

    val _genericErrorMessage: MutableLiveData<String>
    val genericErrorMessage: LiveData<String> get() = _genericErrorMessage

    val _isLoading: MutableLiveData<Boolean>
    val isLoading: LiveData<Boolean> get() = _isLoading

}