package com.poul.android.test.data.api

import com.squareup.moshi.Json

data class Links(
    @field:Json(name = "mission_patch") val missionPatch: String,
    @field:Json(name = "mission_patch_small") val missionPatchSmall: String,
    @field:Json(name = "reddit_campaign") val redditCampaign: Any?,
    @field:Json(name = "reddit_launch") val redditLaunch: Any?,
    @field:Json(name = "reddit_recovery") val redditRecovery: Any?,
    @field:Json(name = "reddit_media") val redditMedia: Any?,
    @field:Json(name = "presskit") val presskit: Any?,
    @field:Json(name = "article_link") val articleLink: String,
    @field:Json(name = "wikipedia") val wikipedia: String,
    @field:Json(name = "video_link") val videoLink: String,
    @field:Json(name = "youtube_id") val youtubeId: String,
    @field:Json(name = "flickr_images") val flickrImages: List<Any?> = emptyList()
)