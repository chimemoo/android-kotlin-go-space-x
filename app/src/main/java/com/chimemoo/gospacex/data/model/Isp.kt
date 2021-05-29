package com.chimemoo.gospacex.data.model

import com.google.gson.annotations.SerializedName

data class Isp(
    @SerializedName("sea_level")
    val seaLevel: Int = 0,

    @SerializedName("vacuum")
    val vacuum: Int = 0
)
