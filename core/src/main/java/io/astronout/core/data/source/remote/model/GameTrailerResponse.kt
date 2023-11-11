package io.astronout.core.data.source.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GameTrailerResponse(
    @Json(name = "count")
    val count: Int? = null,
    @Json(name = "next")
    val next: Any? = null,
    @Json(name = "previous")
    val previous: Any? = null,
    @Json(name = "results")
    val results: List<Result?>? = null
) {
    @JsonClass(generateAdapter = true)
    data class Result(
        @Json(name = "id")
        val id: Int? = null,
        @Json(name = "name")
        val name: String? = null,
        @Json(name = "preview")
        val preview: String? = null,
        @Json(name = "data")
        val data: Data? = null
    ) {
        @JsonClass(generateAdapter = true)
        data class Data(
            @Json(name = "480")
            val x480: String? = null,
            @Json(name = "max")
            val max: String? = null
        )
    }
}