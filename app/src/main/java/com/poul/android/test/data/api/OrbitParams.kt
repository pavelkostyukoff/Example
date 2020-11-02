package com.poul.android.test.data.api

import com.squareup.moshi.Json

data class OrbitParams(
    @field:Json(name = "reference_system") val referenceSystem: String,
    @field:Json(name = "regime") val regime: String,
    @field:Json(name = "longitude") val longitude: Any?,
    @field:Json(name = "semi_major_axis_km") val semiMajorAxisKm: Any?,
    @field:Json(name = "eccentricity") val eccentricity: Any?,
    @field:Json(name = "periapsis_km") val periapsisKm: Any?,
    @field:Json(name = "apoapsis_km") val apoapsisKm: Any?,
    @field:Json(name = "inclination_deg") val inclinationDeg: Any?,
    @field:Json(name = "period_min") val periodMin: Any?,
    @field:Json(name = "lifespan_years") val lifespanYears: Any?,
    @field:Json(name = "epoch") val epoch: Any?,
    @field:Json(name = "mean_motion") val meanMotion: Any?,
    @field:Json(name = "raan") val raan: Any?,
    @field:Json(name = "arg_of_pericenter") val argOfPericenter: Any?,
    @field:Json(name = "mean_anomaly") val meanAnomaly: Any?
)