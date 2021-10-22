package com.android.app.userexample.view_model.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.app.userexample.network.model.base.ResultWrapper
import kotlinx.coroutines.launch

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
abstract class BaseViewModel: ViewModel(), IBaseViewModel {

    override val _genericErrorMessage = MutableLiveData<String>()
    override val _isLoading = MutableLiveData<Boolean>()

    protected fun <T> onError(response: ResultWrapper<T>) =
        with(_genericErrorMessage) {
            when (response) {
                is ResultWrapper.GenericError -> postValue(response.error)
                is ResultWrapper.NetworkError -> postValue("Please check your internet connection")
                else -> postValue("Ooops! Something went wrong")
            }
        }


    protected fun performRequest(showSpinner: Boolean = false, block: suspend () -> Unit) {
        viewModelScope.launch {
            if (showSpinner) _isLoading.postValue(true)
            block()
            if (showSpinner) _isLoading.postValue(false)
        }
    }

}