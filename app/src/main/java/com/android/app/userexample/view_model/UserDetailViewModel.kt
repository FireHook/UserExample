package com.android.app.userexample.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.app.userexample.adapter.base.Mapper
import com.android.app.userexample.network.model.UserModel
import com.android.app.userexample.network.repository.base.StorageRepository
import com.android.app.userexample.view.entity.UserDetailEntity
import com.android.app.userexample.view_model.base.BaseViewModel
import com.android.app.userexample.view_model.base.Event

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
class UserDetailViewModel(
    private val storageRepository: StorageRepository,
    private val userDetailMapper: Mapper<UserModel, UserDetailEntity>
): BaseViewModel() {

    private val _users = MutableLiveData<Event<UserDetailEntity>>()
    val users: LiveData<Event<UserDetailEntity>> get() = _users

    fun getUsersDetails(userId: Int) {
        storageRepository.userModelList.find {
            it.id == userId
        }?.let {
            _users.value = Event(
                userDetailMapper.transform(
                    it
                )
            )
        } ?: run {
            _genericErrorMessage.value = "Can't find user in storage"
        }
    }

}