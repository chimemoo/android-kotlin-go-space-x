package com.chimemoo.gospacex.data.model

import com.google.gson.annotations.SerializedName

data class Launchpad(
    @SerializedName("name")
    val name: String = "",

    @SerializedName("full_name")
    val fullName: String = "",

    @SerializedName("locality")
    val locality: String = "",

    @SerializedName("region")
    val region: String = "",

    @SerializedName("timezone")
    val timeZone: String = "",

    @SerializedName("latitude")
    val latitude: Float = 0f,

    @SerializedName("longitude")
    val longitude: Float = 0f,

    @SerializedName("launch_attempts")
    val launchAttempts: Int = 0,

    @SerializedName("launch_successes")
    val launchSuccesses: Int = 0,

    @SerializedName("rockets")
    val rockets: Array<String>,

    @SerializedName("launches")
    val launches: Array<String>,

    @SerializedName("details")
    val details: String = "",

    @SerializedName("status")
    val status: Boolean = false,

    @SerializedName("id")
    val id: String = ""
)
