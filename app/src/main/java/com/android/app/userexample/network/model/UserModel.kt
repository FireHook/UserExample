package com.android.app.userexample.network.model

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
data class UserModel(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: AddressModel,
    val phone: String,
    val website: String,
    val company: CompanyModel
) {
    companion object {
        val empty = UserModel(
            0,
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
    }
}