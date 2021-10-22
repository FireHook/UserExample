package com.android.app.userexample.network.base

import com.android.app.userexample.network.model.UserModel
import retrofit2.http.GET

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
interface UserApiEngine {
    @GET("/users")
    suspend fun getUsers(): List<UserModel>
}