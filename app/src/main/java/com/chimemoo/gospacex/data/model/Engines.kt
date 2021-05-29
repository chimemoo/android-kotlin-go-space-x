package com.chimemoo.gospacex.data.model

import com.google.gson.annotations.SerializedName

data class Engines(
    @SerializedName("isp")
    val isp: Isp,

    @SerializedName("thrust_sea_level")
    val thrustSeaLevel: Thrust,

    @SerializedName("thrust_vacuum")
    val thrustVacuum: Thrust,

    @SerializedName("number")
    val number: Int = 0,

    @SerializedName("type")
    val type: String = "",

    @SerializedName("version")
    val version: String = "",

    @SerializedName("layout")
    val layout: String? = "",

    @SerializedName("engine_loss_max")
    val engineLossMax: Int? = 0,

    @SerializedName("propellant_1")
    val propellant1: String? = "",

    @SerializedName("propellant_2")
    val propellant2: String? = "",

    @SerializedName("thrust_to_weight")
    val thrustToWeight: Float? = 0f
)
