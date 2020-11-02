package com.poul.android.test.data.api

import com.squareup.moshi.Json

data class LaunchFailureDetails(
    @field:Json(name = "time") val time: Int?,
    @field:Json(name = "altitude") val altitude: Int?,
    @field:Json(name = "reason") val reason: String?
)