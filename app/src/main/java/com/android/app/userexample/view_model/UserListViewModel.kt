package com.android.app.userexample.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.app.userexample.adapter.base.Mapper
import com.android.app.userexample.network.model.UserModel
import com.android.app.userexample.network.model.base.ResultWrapper
import com.android.app.userexample.network.repository.base.StorageRepository
import com.android.app.userexample.network.repository.base.UserRepository
import com.android.app.userexample.view.entity.UserEntity
import com.android.app.userexample.view_model.base.BaseViewModel
import com.android.app.userexample.view_model.base.Event

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
class UserListViewModel(
    private val userRepository: UserRepository,
    private val storageRepository: StorageRepository,
    private val userMapper: Mapper<List<UserModel>, List<UserEntity>>
): BaseViewModel() {

    private val _users = MutableLiveData<Event<List<UserEntity>>>()
    val userEntityList: LiveData<Event<List<UserEntity>>> get() = _users

    fun getUserEntityList() = performRequest(true) {
        when(val response = userRepository.getUsers()) {
            is ResultWrapper.Success -> {
                storageRepository.userModelList = response.value
                _users.value = Event(userMapper.transform(response.value))
            }
            else -> onError(response)
        }
    }

    fun sortUsersById() {
        _users.value = Event(
            userMapper.transform(
                storageRepository.userModelList.sortedBy { it.id }
            )
        )
    }

    fun sortUsersByUsername() {
        _users.value = Event(
            userMapper.transform(
                storageRepository.userModelList.sortedBy { it.username }
            )
        )
    }

}