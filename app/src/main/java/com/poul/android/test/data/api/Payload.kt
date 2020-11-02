package com.poul.android.test.data.api

import com.squareup.moshi.Json

data class Payload(
    @field:Json(name = "payload_id") val payloadId: String,
    @field:Json(name = "norad_id") val noradId: List<Any?> = emptyList(),
    @field:Json(name = "reused") val reused: Boolean?,
    @field:Json(name = "customers") val customers: List<String?> = emptyList(),
    @field:Json(name = "nationality") val nationality: String,
    @field:Json(name = "manufacturer") val manufacturer: String,
    @field:Json(name = "payload_type") val payloadType: String,
    @field:Json(name = "payload_mass_kg") val payloadMassKg: Any?,
    @field:Json(name = "payload_mass_lbs") val payloadMassLbs: Any?,
    @field:Json(name = "orbit") val orbit: String,
    @field:Json(name = "orbit_params") val orbitParams: OrbitParams
)