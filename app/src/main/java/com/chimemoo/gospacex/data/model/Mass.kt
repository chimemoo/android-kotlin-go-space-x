package com.chimemoo.gospacex.data.model

import com.google.gson.annotations.SerializedName

data class Mass(
    @SerializedName("kg")
    val kg: Float = 0f,

    @SerializedName("lb")
    val lb: Float = 0f,
)
