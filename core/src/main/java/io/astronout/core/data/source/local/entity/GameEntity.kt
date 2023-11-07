package io.astronout.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import io.astronout.core.data.source.local.room.StringTypeConverter
import io.astronout.core.data.source.remote.model.GamesResponse

@Entity(tableName = "game")
@TypeConverters(StringTypeConverter::class)
data class GameEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "slug")
    val slug: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "released")
    val released: String,
    @ColumnInfo(name = "tba")
    val tba: Boolean,
    @ColumnInfo(name = "background_image")
    val backgroundImage: String,
    @ColumnInfo(name = "rating")
    val rating: Double,
    @ColumnInfo(name = "rating_top")
    val ratingTop: Int,
    @ColumnInfo(name = "ratings_count")
    val ratingsCount: Int,
    @ColumnInfo(name = "reviews_text_count")
    val reviewsTextCount: Int,
    @ColumnInfo(name = "added")
    val added: Int,
    @ColumnInfo(name = "metacritic")
    val metacritic: Int,
    @ColumnInfo(name = "playtime")
    val playtime: Int,
    @ColumnInfo(name = "suggestions_count")
    val suggestionsCount: Int,
    @ColumnInfo(name = "updated")
    val updated: String,
    @ColumnInfo(name = "reviews_count")
    val reviewsCount: Int,
    @ColumnInfo(name = "saturated_color")
    val saturatedColor: String,
    @ColumnInfo(name = "dominant_color")
    val dominantColor: String,
    @ColumnInfo(name = "parent_platforms")
    val parentPlatforms: List<String>,
    @ColumnInfo(name = "genres")
    val genres: List<String>,
    @ColumnInfo(name = "stores")
    val stores: List<String>,
    @ColumnInfo(name = "tags")
    val tags: List<String>,
    @ColumnInfo(name = "esrb_rating")
    val esrbRating: String,
    @ColumnInfo(name = "short_screenshots")
    val shortScreenshots: List<String>,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "is_favorites")
    var isFavorites: Boolean
) {
    constructor(data: GamesResponse.Game?): this(
        id = data?.id ?: 0,
        slug = data?.slug.orEmpty(),
        name = data?.name.orEmpty(),
        released = data?.released.orEmpty(),
        tba = data?.tba ?: false,
        backgroundImage = data?.backgroundImage.orEmpty(),
        rating = data?.rating ?: 0.0,
        ratingTop = data?.ratingTop ?: 0,
        ratingsCount = data?.ratingsCount ?: 0,
        reviewsTextCount = data?.reviewsTextCount ?: 0,
        added = data?.added ?: 0,
        metacritic = data?.metacritic ?: 0,
        playtime = data?.playtime ?: 0,
        suggestionsCount = data?.suggestionsCount ?: 0,
        updated = data?.updated.orEmpty(),
        reviewsCount = data?.reviewsCount ?: 0,
        saturatedColor = data?.saturatedColor.orEmpty(),
        dominantColor = data?.dominantColor.orEmpty(),
        parentPlatforms = data?.parentPlatforms?.map { it.platform?.name.orEmpty() }.orEmpty(),
        genres = data?.genres?.map { it.name.orEmpty() }.orEmpty(),
        stores = data?.stores?.map { it.store?.name.orEmpty() }.orEmpty(),
        tags = data?.tags?.map { it.name.orEmpty() }.orEmpty(),
        esrbRating = data?.esrbRating?.name.orEmpty(),
        shortScreenshots = data?.shortScreenshots?.map { it.image.orEmpty() }.orEmpty(),
        description = "",
        isFavorites = false
    )
}