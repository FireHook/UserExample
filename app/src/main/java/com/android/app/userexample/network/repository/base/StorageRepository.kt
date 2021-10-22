package com.android.app.userexample.network.repository.base

import com.android.app.userexample.network.model.UserModel

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
interface StorageRepository {
    var userModelList: List<UserModel>
}