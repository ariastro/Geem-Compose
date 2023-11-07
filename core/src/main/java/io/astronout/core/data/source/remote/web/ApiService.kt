package io.astronout.core.data.source.remote.web

import com.skydoves.sandwich.ApiResponse
import io.astronout.core.data.source.remote.model.GamesResponse
import retrofit2.http.*
import java.util.*

interface ApiService {

    @GET("games")
    suspend fun getAllGames(): ApiResponse<GamesResponse>

    @GET("games")
    suspend fun searchGames(
        @Query("search") query: String
    ): ApiResponse<GamesResponse>

}