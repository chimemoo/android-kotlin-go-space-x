package com.chimemoo.gospacex.data.model

import com.google.gson.annotations.SerializedName
data class Launch(
    @SerializedName("fairings")
    val fairings: Fairings,

    @SerializedName("links")
    val link: Link,

    @SerializedName("static_fire_date_utc")
    val staticFireDateUtc: String? = "",

    @SerializedName("static_fire_date_unix")
    val staticFireDateUnix: String? = "",

    @SerializedName("tbd")
    val tbd: Boolean? = false,

    @SerializedName("net")
    val net: Boolean? = false,

    @SerializedName("window")
    val window: Int? = 0,

    @SerializedName("rocket")
    val rocket: String? = "",

    @SerializedName("success")
    val success: Boolean? = false,

    @SerializedName("details")
    val details: String? = "",

    @SerializedName("crew")
    val crew: Array<String>,

    @SerializedName("ships")
    val ships: Array<String>,

    @SerializedName("capsules")
    val capsules: Array<String>,

    @SerializedName("payloads")
    val payloads: Array<String>,

    @SerializedName("launchpad")
    val launchpad: String? = "",

    @SerializedName("auto_update")
    val autoUpdate: Boolean? = false,

    @SerializedName("launch_library_id")
    val launchLibraryId: String? = "",

    @SerializedName("name")
    val name: String? = "",

    @SerializedName("date")
    val date: String? = "",

    @SerializedName("date_utc")
    val dateUtc: String? = "",

    @SerializedName("date_local")
    val dateLocal: String? = "",

    @SerializedName("upcoming")
    val upcoming: Boolean? = false,
)

