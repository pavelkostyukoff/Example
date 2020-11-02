package com.poul.android.test.data.api

import com.squareup.moshi.Json

data class Core(
    @field:Json(name = "core_serial") val coreSerial: String,
    @field:Json(name = "flight") val flight: Int?,
    @field:Json(name = "block") val block: Any?,
    @field:Json(name = "gridfins") val gridfins: Boolean?,
    @field:Json(name = "legs") val legs: Boolean?,
    @field:Json(name = "reused") val reused: Boolean?,
    @field:Json(name = "land_success") val landSuccess: Any?,
    @field:Json(name = "landing_intent") val landingIntent: Boolean?,
    @field:Json(name = "landing_type") val landingType: Any?,
    @field:Json(name = "landing_vehicle") val landingVehicle: Any?
)