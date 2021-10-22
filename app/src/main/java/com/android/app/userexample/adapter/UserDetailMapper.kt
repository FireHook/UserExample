package com.android.app.userexample.adapter

import com.android.app.userexample.adapter.base.Mapper
import com.android.app.userexample.network.model.UserModel
import com.android.app.userexample.view.entity.UserDetailEntity

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
class UserDetailMapper: Mapper<UserModel, UserDetailEntity> {
    override fun transform(from: UserModel) = UserDetailEntity(
        from.name,
        from.username,
        from.address.city
    )
}