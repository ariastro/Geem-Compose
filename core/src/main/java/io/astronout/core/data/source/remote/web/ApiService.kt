package io.astronout.core.data.source.remote.web

import com.skydoves.sandwich.ApiResponse
import io.astronout.core.data.source.remote.model.GameItem
import io.astronout.core.data.source.remote.model.GamesResponse
import retrofit2.http.*
import java.util.*

interface ApiService {

    @GET("games")
    suspend fun getAllGames(
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize: Int? = null,
        @Query("search") search: String? = null,
        @Query("search_precise") searchPrecise: Boolean? = null,
        @Query("search_exact") searchExact: Boolean? = null,
        @Query("parent_platforms") parentPlatforms: String? = null,
        @Query("platforms") platforms: String? = null,
        @Query("stores") stores: String? = null,
        @Query("developers") developers: String? = null,
        @Query("publishers") publishers: String? = null,
        @Query("genres") genres: String? = null,
        @Query("tags") tags: String? = null,
        @Query("creators") creators: String? = null,
        @Query("dates") dates: String? = null,
        @Query("updated") updated: String? = null,
        @Query("platforms_count") platformsCount: Int? = null,
        @Query("metacritic") metacritic: String? = null,
        @Query("exclude_collection") excludeCollection: Int? = null,
        @Query("exclude_additions") excludeAdditions: Boolean? = null,
        @Query("exclude_parents") excludeParents: Boolean? = null,
        @Query("exclude_game_series") excludeGameSeries: Boolean? = null,
        @Query("exclude_stores") excludeStores: String? = null,
        @Query("ordering") ordering: String? = null,
    ): ApiResponse<GamesResponse>

    @GET("games/{id}")
    suspend fun getGameDetails(
        @Path("id") id: Long
    ): ApiResponse<GameItem>

}