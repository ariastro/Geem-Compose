package io.astronout.core.data.source.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GameItem(
    @Json(name = "id")
    val id: Long? = null,
    @Json(name = "slug")
    val slug: String? = null,
    @Json(name = "description_raw")
    val description: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "released")
    val released: String? = null,
    @Json(name = "tba")
    val tba: Boolean? = null,
    @Json(name = "background_image")
    val backgroundImage: String? = null,
    @Json(name = "rating")
    val rating: Double? = null,
    @Json(name = "rating_top")
    val ratingTop: Int? = null,
    @Json(name = "ratings")
    val ratings: List<Rating>? = null,
    @Json(name = "ratings_count")
    val ratingsCount: Int? = null,
    @Json(name = "reviews_text_count")
    val reviewsTextCount: Int? = null,
    @Json(name = "added")
    val added: Int? = null,
    @Json(name = "added_by_status")
    val addedByStatus: AddedByStatus? = null,
    @Json(name = "metacritic")
    val metacritic: Int? = null,
    @Json(name = "playtime")
    val playtime: Int? = null,
    @Json(name = "suggestions_count")
    val suggestionsCount: Int? = null,
    @Json(name = "updated")
    val updated: String? = null,
    @Json(name = "user_game")
    val userGame: Any? = null,
    @Json(name = "reviews_count")
    val reviewsCount: Int? = null,
    @Json(name = "saturated_color")
    val saturatedColor: String? = null,
    @Json(name = "dominant_color")
    val dominantColor: String? = null,
    @Json(name = "platforms")
    val platforms: List<Platform>? = null,
    @Json(name = "parent_platforms")
    val parentPlatforms: List<ParentPlatform>? = null,
    @Json(name = "genres")
    val genres: List<Genre>? = null,
    @Json(name = "stores")
    val stores: List<Store>? = null,
    @Json(name = "clip")
    val clip: Any? = null,
    @Json(name = "tags")
    val tags: List<Tag>? = null,
    @Json(name = "esrb_rating")
    val esrbRating: EsrbRating? = null,
    @Json(name = "short_screenshots")
    val shortScreenshots: List<ShortScreenshot>? = null
) {
    @JsonClass(generateAdapter = true)
    data class Rating(
        @Json(name = "id")
        val id: Int? = null,
        @Json(name = "title")
        val title: String? = null,
        @Json(name = "count")
        val count: Int? = null,
        @Json(name = "percent")
        val percent: Double? = null
    )

    @JsonClass(generateAdapter = true)
    data class AddedByStatus(
        @Json(name = "yet")
        val yet: Int? = null,
        @Json(name = "owned")
        val owned: Int? = null,
        @Json(name = "beaten")
        val beaten: Int? = null,
        @Json(name = "toplay")
        val toplay: Int? = null,
        @Json(name = "dropped")
        val dropped: Int? = null,
        @Json(name = "playing")
        val playing: Int? = null
    )

    @JsonClass(generateAdapter = true)
    data class Platform(
        @Json(name = "platform")
        val platform: PlatformChild? = null,
        @Json(name = "released_at")
        val releasedAt: String? = null,
        @Json(name = "requirements_en")
        val requirementsEn: RequirementsEn? = null,
        @Json(name = "requirements_ru")
        val requirementsRu: RequirementsRu? = null
    ) {
        @JsonClass(generateAdapter = true)
        data class PlatformChild(
            @Json(name = "id")
            val id: Int? = null,
            @Json(name = "name")
            val name: String? = null,
            @Json(name = "slug")
            val slug: String? = null,
            @Json(name = "image")
            val image: Any? = null,
            @Json(name = "year_end")
            val yearEnd: Any? = null,
            @Json(name = "year_start")
            val yearStart: Int? = null,
            @Json(name = "games_count")
            val gamesCount: Int? = null,
            @Json(name = "image_background")
            val imageBackground: String? = null
        )

        @JsonClass(generateAdapter = true)
        data class RequirementsEn(
            @Json(name = "minimum")
            val minimum: String? = null,
            @Json(name = "recommended")
            val recommended: String? = null
        )

        @JsonClass(generateAdapter = true)
        data class RequirementsRu(
            @Json(name = "minimum")
            val minimum: String? = null,
            @Json(name = "recommended")
            val recommended: String? = null
        )
    }

    @JsonClass(generateAdapter = true)
    data class ParentPlatform(
        @Json(name = "platform")
        val platform: Platform? = null
    ) {
        @JsonClass(generateAdapter = true)
        data class Platform(
            @Json(name = "id")
            val id: Int? = null,
            @Json(name = "name")
            val name: String? = null,
            @Json(name = "slug")
            val slug: String? = null
        )
    }

    @JsonClass(generateAdapter = true)
    data class Genre(
        @Json(name = "id")
        val id: Int? = null,
        @Json(name = "name")
        val name: String? = null,
        @Json(name = "slug")
        val slug: String? = null,
        @Json(name = "games_count")
        val gamesCount: Int? = null,
        @Json(name = "image_background")
        val imageBackground: String? = null
    )

    @JsonClass(generateAdapter = true)
    data class Store(
        @Json(name = "id")
        val id: Int? = null,
        @Json(name = "store")
        val store: StoreChild? = null
    ) {
        @JsonClass(generateAdapter = true)
        data class StoreChild(
            @Json(name = "id")
            val id: Int? = null,
            @Json(name = "name")
            val name: String? = null,
            @Json(name = "slug")
            val slug: String? = null,
            @Json(name = "domain")
            val domain: String? = null,
            @Json(name = "games_count")
            val gamesCount: Int? = null,
            @Json(name = "image_background")
            val imageBackground: String? = null
        )
    }

    @JsonClass(generateAdapter = true)
    data class Tag(
        @Json(name = "id")
        val id: Int? = null,
        @Json(name = "name")
        val name: String? = null,
        @Json(name = "slug")
        val slug: String? = null,
        @Json(name = "language")
        val language: String? = null,
        @Json(name = "games_count")
        val gamesCount: Int? = null,
        @Json(name = "image_background")
        val imageBackground: String? = null
    )

    @JsonClass(generateAdapter = true)
    data class EsrbRating(
        @Json(name = "id")
        val id: Int? = null,
        @Json(name = "name")
        val name: String? = null,
        @Json(name = "slug")
        val slug: String? = null
    )

    @JsonClass(generateAdapter = true)
    data class ShortScreenshot(
        @Json(name = "id")
        val id: Int? = null,
        @Json(name = "image")
        val image: String? = null
    )
}