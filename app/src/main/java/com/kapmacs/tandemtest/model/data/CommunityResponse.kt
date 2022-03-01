package com.kapmacs.tandemtest.model.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CommunityResponse(
    @Json(name = "errorCode")
    val errorCode: Any?,
    @Json(name = "response")
    val members: List<Member>,
    @Json(name = "type")
    val type: String
)
