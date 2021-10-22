package com.android.app.userexample.adapter

import com.android.app.userexample.adapter.base.Mapper
import com.android.app.userexample.network.model.UserModel
import com.android.app.userexample.view.entity.UserEntity

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
class UserEntityMapper: Mapper<List<UserModel>, List<UserEntity>> {
    override fun transform(from: List<UserModel>): List<UserEntity> {
        val result = mutableListOf<UserEntity>()
        from.forEach {
            result.add(
                UserEntity(
                    it.id,
                    it.name,
                    it.username
                )
            )
        }
        return result
    }

}