package com.chimemoo.gospacex.data.model

import com.google.gson.annotations.SerializedName

data class CompositeFairing(
    @SerializedName("height")
    val height: Height,

    @SerializedName("diameter")
    val diameter: Diameter
)
