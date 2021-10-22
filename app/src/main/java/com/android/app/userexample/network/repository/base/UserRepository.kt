package com.android.app.userexample.network.repository.base

import com.android.app.userexample.network.model.UserModel
import com.android.app.userexample.network.model.base.ResultWrapper

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
interface UserRepository {
    suspend fun getUsers(): ResultWrapper<List<UserModel>>
}