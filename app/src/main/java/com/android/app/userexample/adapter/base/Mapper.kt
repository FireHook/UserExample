package com.android.app.userexample.adapter.base

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
interface Mapper<T, R> {
    fun transform(from: T): R
}