package com.android.app.userexample.network.model.base

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T): ResultWrapper<T>()
    data class GenericError(val code: Int? = null, val error: String?): ResultWrapper<Nothing>()
    object NetworkError: ResultWrapper<Nothing>()
}