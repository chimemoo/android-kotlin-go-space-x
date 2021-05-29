package com.chimemoo.gospacex.data.model

import com.google.gson.annotations.SerializedName

data class Rocket(
    @SerializedName("height")
    val height: Height,

    @SerializedName("diameter")
    val diameter: Diameter,

    @SerializedName("mass")
    val mass: Mass,

    @SerializedName("first_stage")
    val firstStage: FirstStage,

    @SerializedName("second_stage")
    val secondStage: SecondStage,

    @SerializedName("engines")
    val engines: Engines,

    @SerializedName("landing_legs")
    val landingLegs: LandingLegs,

    @SerializedName("payload_weights")
    val payloadWeight: Array<Weight>,

    @SerializedName("flickr_images")
    val flickrImages: Array<String>,

    @SerializedName("name")
    val name: String = "",

    @SerializedName("type")
    val type: String = "",

    @SerializedName("active")
    val active: Boolean = false,

    @SerializedName("stages")
    val stages: Int = 0,

    @SerializedName("boosters")
    val boosters: Int = 0,

    @SerializedName("cost_per_launch")
    val costPerLaunch: Int = 0,

    @SerializedName("success_rate_pct")
    val successRatePtc: Int = 0,

    @SerializedName("first_flight")
    val firstFlight: String = "",

    @SerializedName("country")
    val country: String = "",

    @SerializedName("company")
    val company: String = "",

    @SerializedName("wikipedia")
    val wikipedia: String = "",

    @SerializedName("description")
    val description: String = "",

    @SerializedName("id")
    val id: String = ""
)
