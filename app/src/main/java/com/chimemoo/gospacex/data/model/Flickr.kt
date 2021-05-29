package com.chimemoo.gospacex.data.model

import com.google.gson.annotations.SerializedName

data class Flickr(
    @SerializedName("small")
    val small: Array<String>,

    @SerializedName("original")
    val original: Array<String>,
)
