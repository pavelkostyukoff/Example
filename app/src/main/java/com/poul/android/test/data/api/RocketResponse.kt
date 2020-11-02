
package com.poul.android.test.data.api

import com.squareup.moshi.Json

data class RocketResponse(
  @field:Json(name = "flight_number") val flightNumber: Int?,
  @field:Json(name = "mission_name") val missionName: String,
  @field:Json(name = "mission_id") val missionId: List<Any?> = emptyList(),
  @field:Json(name = "upcoming") val upcoming: Boolean?,
  @field:Json(name = "launch_year") val launchYear: String,
  @field:Json(name = "launch_date_unix") val launchDateUnix: Int?,
  @field:Json(name = "launch_date_utc") val launchDateUtc: String,
  @field:Json(name = "launch_date_local") val launchDateLocal: String,
  @field:Json(name = "is_tentative") val isTentative: Boolean?,
  @field:Json(name= "tentative_max_precision") val tentativeMaxPrecision: String,
  @field:Json(name = "tbd") val tbd: Boolean?,
  @field:Json(name = "launch_window") val launchWindow: Int?,
  @field:Json(name = "rocket") val rocket: Rocket,
  @field:Json(name = "ships") val ships: List<Any?> = emptyList(),
  @field:Json(name = "telemetry") val telemetry: Telemetry,
  @field:Json(name = "launch_site") val launchSite: LaunchSite,
  @field:Json(name = "launch_success") val launchSuccess: Boolean?,
  @field:Json(name = "launch_failure_details") val launchFailureDetails: LaunchFailureDetails,
  @field:Json(name = "links") val links: Links,
  @field:Json(name = "details") val details: String,
  @field:Json(name = "static_fire_date_utc") val staticFireDateUtc: Any,
  @field:Json(name = "static_fire_date_unix") val staticFireDateUnix: Any,
  @field:Json(name = "timeline") val timeline: Timeline,
  @field:Json(name = "crew") val crew: Any
)