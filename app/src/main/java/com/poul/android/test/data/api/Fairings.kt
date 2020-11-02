package com.poul.android.test.data.api

import com.squareup.moshi.Json

data class Fairings(
    @field:Json(name = "reused") val reused: Boolean?,
    @field:Json(name = "recovery_attempt") val recoveryAttempt: Boolean?,
    @field:Json(name = "recovered") val recovered: Boolean?,
    @field:Json(name = "ship") val ship: Any?
)