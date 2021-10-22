package com.android.app.userexample.network.base

import com.android.app.userexample.network.model.base.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */

suspend fun <T> safeApiCall(apiCall: suspend () -> T): ResultWrapper<T> {
    return withContext(Dispatchers.IO) {
        try {
            ResultWrapper.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> ResultWrapper.NetworkError
                is HttpException -> {
                    ResultWrapper.GenericError(throwable.code(), throwable.message)
                }
                else -> {
                    Timber.e("safe api call error: ${throwable.message}")
                    ResultWrapper.GenericError(null, throwable.message)
                }
            }
        }
    }
}