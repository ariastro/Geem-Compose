package io.astronout.core.data.source.remote

import com.skydoves.sandwich.ApiResponse
import io.astronout.core.data.source.remote.model.GamesResponse
import io.astronout.core.data.source.remote.web.ApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val api: ApiService) : ApiService {

    override suspend fun getAllGames(): ApiResponse<GamesResponse> {
        return api.getAllGames()
    }

    override suspend fun searchGames(query: String): ApiResponse<GamesResponse> {
        return api.searchGames(query)
    }

}