package com.chimemoo.gospacex.data.model

import com.google.gson.annotations.SerializedName

data class Fairings(
    @SerializedName("reused")
    val reused: Boolean? = false,

    @SerializedName("recovery_attempt")
    val recoveryAttempt: Boolean? = false,

    @SerializedName("recovered")
    val recovered: Boolean? = false,

    @SerializedName("ships")
    val ships: Array<String>,
)
