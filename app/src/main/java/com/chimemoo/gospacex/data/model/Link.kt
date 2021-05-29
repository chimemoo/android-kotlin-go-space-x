package com.chimemoo.gospacex.data.model

import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("patch")
    val patch: Patch?,

    @SerializedName("reddit")
    val reddit: Reddit?,

    @SerializedName("flickr")
    val flickr: Flickr?,

    @SerializedName("presskit")
    val preskit: String? = "",

    @SerializedName("webcast")
    val webcast: String? = "",

    @SerializedName("youtube_id")
    val youtubeId: String? = "",

    @SerializedName("article")
    val article: String? = "",

    @SerializedName("wikipedia")
    val wikipedia: String? = ""
)
