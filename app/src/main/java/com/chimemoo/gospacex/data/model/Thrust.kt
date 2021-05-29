package com.chimemoo.gospacex.data.model

import com.google.gson.annotations.SerializedName

data class Thrust(
    @SerializedName("kN")
    val kN: Int = 0,

    @SerializedName("lbf")
    val lbf: Int = 0
)
