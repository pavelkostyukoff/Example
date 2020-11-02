package com.poul.android.test.data.api

import com.squareup.moshi.Json

data class Timeline(
    @field:Json(name = "webcast_liftoff") val webcastLiftoff: Int?
)