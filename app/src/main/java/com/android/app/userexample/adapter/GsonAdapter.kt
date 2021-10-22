package com.android.app.userexample.adapter

import com.android.app.userexample.adapter.base.JsonAdapter
import com.google.gson.Gson
import java.lang.reflect.Type

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
class GsonAdapter (
    private val gson: Gson
): JsonAdapter {
    override fun <T> serialize(value: T): String = gson.toJson(value)

    override fun <T> deserialize(source: String, type: Type): T? = gson.fromJson(source, type)
}