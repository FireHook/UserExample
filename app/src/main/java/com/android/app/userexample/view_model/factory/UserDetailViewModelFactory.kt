package com.android.app.userexample.view_model.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.app.userexample.adapter.UserDetailMapper
import com.android.app.userexample.network.repository.base.RepositoryFactory
import com.android.app.userexample.view_model.UserDetailViewModel

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
class UserDetailViewModelFactory(
    private val context: Context
    ) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserDetailViewModel(
            RepositoryFactory.buildStorageRepository(context),
            UserDetailMapper()
        ) as T
    }
}