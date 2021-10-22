package com.android.app.userexample

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.app.userexample.adapter.UserEntityMapper
import com.android.app.userexample.network.model.AddressModel
import com.android.app.userexample.network.model.CompanyModel
import com.android.app.userexample.network.model.GeoModel
import com.android.app.userexample.network.model.UserModel
import com.android.app.userexample.network.repository.base.StorageRepository
import com.android.app.userexample.network.repository.base.UserRepository
import com.android.app.userexample.view_model.UserListViewModel
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.robolectric.annotation.Config

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class UserListViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var exception = ExpectedException.none()

    lateinit var viewModel: UserListViewModel
    lateinit var mockStorageRepository: StorageRepository
    lateinit var mockUserRepository: UserRepository

    @Before
    fun setUp() {
        mockUserRepository = Mockito.mock(UserRepository::class.java)
        mockStorageRepository = Mockito.mock(StorageRepository::class.java)

        viewModel = UserListViewModel(
            mockUserRepository, mockStorageRepository, UserEntityMapper()
        )
    }

    @Test
    fun `sort by Id with 1 2 3 userId`() = with(viewModel) {
        `when`(mockStorageRepository.userModelList).thenReturn(createMockedUserListWith123UserId())
        sortUsersById()
        val result = userEntityList.getOrAwaitValue()
        MatcherAssert.assertThat(result.peekContent()[0].id, CoreMatchers.equalTo(1))
        MatcherAssert.assertThat(result.peekContent()[1].id, CoreMatchers.equalTo(2))
        MatcherAssert.assertThat(result.peekContent()[2].id, CoreMatchers.equalTo(3))
    }

    @Test
    fun `sort by Username with A B C Username`() = with(viewModel) {
        `when`(mockStorageRepository.userModelList).thenReturn(createMockedUserListWithABCUsername())
        sortUsersByUsername()
        val result = userEntityList.getOrAwaitValue()
        MatcherAssert.assertThat(result.peekContent()[0].username, CoreMatchers.equalTo("A"))
        MatcherAssert.assertThat(result.peekContent()[1].username, CoreMatchers.equalTo("B"))
        MatcherAssert.assertThat(result.peekContent()[2].username, CoreMatchers.equalTo("C"))
    }

    private fun createMockedUserListWith123UserId(): List<UserModel> {
        val mockedList = mutableListOf<UserModel>()
        for (id in 1..3) {
            mockedList.add(
                UserModel(
                    id,
                    "",
                    "",
                    "",
                    AddressModel(
                        "",
                        "",
                        "",
                        "",
                        GeoModel(
                            0f,
                            0f
                        )
                    ),
                    "",
                    "",
                    CompanyModel(
                        "",
                        "",
                        ""
                    )
                )
            )
        }
        return mockedList
    }

    private fun createMockedUserListWithABCUsername(): List<UserModel> {
        val mockedList = mutableListOf<UserModel>()
        for (username in 'A'..'C') {
            mockedList.add(
                UserModel(
                    0,
                    "",
                    username.toString(),
                    "",
                    AddressModel(
                        "",
                        "",
                        "",
                        "",
                        GeoModel(
                            0f,
                            0f
                        )
                    ),
                    "",
                    "",
                    CompanyModel(
                        "",
                        "",
                        ""
                    )
                )
            )
        }
        return mockedList
    }

}