package com.android.app.userexample.network.repository.base

import android.content.Context
import com.android.app.userexample.adapter.GsonAdapter
import com.android.app.userexample.network.base.RetrofitSingleton
import com.android.app.userexample.network.repository.StorageRepositoryImpl
import com.android.app.userexample.network.repository.UserRepositoryImpl
import com.google.gson.Gson

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
object RepositoryFactory {

    fun buildUserRepository() = UserRepositoryImpl(RetrofitSingleton.buildApiEngine())

    fun buildStorageRepository(context: Context) = StorageRepositoryImpl(
        GsonAdapter(Gson()),
        context
    )

}