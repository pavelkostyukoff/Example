package com.poul.android.test.data.api

import com.squareup.moshi.Json

data class FirstStage(
    @field:Json(name = "cores") val cores: List<Core?> = emptyList()
)