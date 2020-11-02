package com.poul.android.test.data.api

import com.squareup.moshi.Json

data class Telemetry(
    @field:Json(name = "flight_club") val flightClub: Any?
)