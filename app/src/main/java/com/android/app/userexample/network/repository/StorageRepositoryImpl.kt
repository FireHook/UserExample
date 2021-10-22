package com.android.app.userexample.network.repository

import android.content.Context
import com.android.app.userexample.get
import com.android.app.userexample.adapter.base.JsonAdapter
import com.android.app.userexample.network.model.UserModel
import com.android.app.userexample.network.repository.base.StorageRepository
import com.android.app.userexample.put
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

private const val sharedPrefsName = "user-prefs"
private const val keyUser = "user"

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
class StorageRepositoryImpl(
    private val jsonAdapter: JsonAdapter,
    context: Context
): StorageRepository {

    private val prefs = context.getSharedPreferences(sharedPrefsName, Context.MODE_PRIVATE)
    private val type: Type = object : TypeToken<List<UserModel>>() {}.type

    override var userModelList: List<UserModel>
        get() = jsonAdapter.deserialize(
            prefs.get(keyUser, ""),
            type
        ) ?: listOf()

        set(value) {
            prefs.put(keyUser, jsonAdapter.serialize(value))
        }
}