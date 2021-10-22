package com.android.app.userexample.adapter.base

import java.lang.reflect.Type

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
interface JsonAdapter {
    fun <T> serialize(value: T): String

    fun <T> deserialize(source: String,  type: Type): T?
}