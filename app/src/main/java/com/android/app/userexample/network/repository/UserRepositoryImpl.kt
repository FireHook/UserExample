package com.android.app.userexample.network.repository

import com.android.app.userexample.network.base.UserApiEngine
import com.android.app.userexample.network.base.safeApiCall
import com.android.app.userexample.network.model.UserModel
import com.android.app.userexample.network.model.base.ResultWrapper
import com.android.app.userexample.network.repository.base.UserRepository

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
class UserRepositoryImpl(
    private val apiEngine: UserApiEngine,
): UserRepository {

    override suspend fun getUsers(): ResultWrapper<List<UserModel>> = safeApiCall {
        apiEngine.getUsers()
    }

}