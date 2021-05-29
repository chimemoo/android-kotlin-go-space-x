package com.chimemoo.gospacex.data.model

import com.google.gson.annotations.SerializedName

data class FirstStage(
    @SerializedName("thrust_sea_level")
    val thrustSeaLevel: Thrust,

    @SerializedName("thrust_vacuum")
    val thrustVacuum: Thrust,

    @SerializedName("reusable")
    val reusable: Boolean = false,

    @SerializedName("engines")
    val engines: Int = 0,

    @SerializedName("fuel_amount_tons")
    val fuelAmountTons: Float? = 0f,

    @SerializedName("burn_time_sec")
    val burnTimeSec: Float? = 0f
)
