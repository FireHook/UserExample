package com.android.app.userexample.network.model

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
data class AddressModel(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: GeoModel
)