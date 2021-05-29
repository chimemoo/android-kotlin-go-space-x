package com.chimemoo.gospacex.data.model

import com.google.gson.annotations.SerializedName

data class Diameter(
    @SerializedName("meters")
    val meters: Float? = 0f,

    @SerializedName("feet")
    val feet: Float? = 0f,
)
