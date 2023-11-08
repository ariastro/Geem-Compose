package io.astronout.core.data.source.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GamesResponse(
    @Json(name = "count")
    val count: Int? = null,
    @Json(name = "next")
    val next: String? = null,
    @Json(name = "previous")
    val previous: Any? = null,
    @Json(name = "results")
    val results: List<GameItem>? = null
)