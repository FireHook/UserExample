package com.android.app.userexample.view_model.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.app.userexample.adapter.UserEntityMapper
import com.android.app.userexample.network.repository.base.RepositoryFactory
import com.android.app.userexample.view_model.UserListViewModel

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
class UserListViewModelFactory(
    private val context: Context
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserListViewModel(
            RepositoryFactory.buildUserRepository(),
            RepositoryFactory.buildStorageRepository(context),
            UserEntityMapper()
        ) as T
    }
}