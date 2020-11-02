package com.poul.android.test.data.api

import com.squareup.moshi.Json

data class SecondStage(
    @field:Json(name = "block") val block: Int?,
    @field:Json(name = "payloads") val payloads: List<Payload?> = emptyList()
)