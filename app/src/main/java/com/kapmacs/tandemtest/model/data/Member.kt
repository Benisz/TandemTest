package com.kapmacs.tandemtest.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class Member(
    @Json(name = "firstName")
    val firstName: String,
    @Json(name = "id")
    @PrimaryKey
    val id: Int,
    @Json(name = "learns")
    val learns: List<String>,
    @Json(name = "natives")
    val natives: List<String>,
    @Json(name = "pictureUrl")
    val pictureUrl: String,
    @Json(name = "referenceCnt")
    val referenceCnt: Int,
    @Json(name = "topic")
    val topic: String,
    var liked: Boolean = false
)
