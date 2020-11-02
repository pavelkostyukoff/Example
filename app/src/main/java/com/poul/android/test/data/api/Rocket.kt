package com.poul.android.test.data.api

import com.squareup.moshi.Json

data class Rocket(
    @field:Json(name = "rocket_id") val rocketId: String,
    @field:Json(name = "rocket_name") val rocketName: String,
    @field:Json(name = "rocket_type") val rocketType: String,
    @field:Json(name = "first_stage") val firstStage: FirstStage,
    @field:Json(name = "second_stage") val secondStage: SecondStage,
    @field:Json(name = "fairings") val fairings: Fairings
)