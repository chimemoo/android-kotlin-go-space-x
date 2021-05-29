package com.chimemoo.gospacex.data.model

import com.google.gson.annotations.SerializedName

data class Weight(
    @SerializedName("id")
    val id: String = "",

    @SerializedName("name")
    val name: String = "",

    @SerializedName("kg")
    val kg: Int = 0,

    @SerializedName("lb")
    val lb: Int = 0
)
