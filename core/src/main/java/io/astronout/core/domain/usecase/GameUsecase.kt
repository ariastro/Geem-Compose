package io.astronout.core.domain.usecase

import io.astronout.core.domain.model.Game
import io.astronout.core.vo.Resource
import kotlinx.coroutines.flow.Flow

interface GameUsecase {

    fun getAllGames(): Flow<Resource<List<Game>>>

    fun getHotGames(): Flow<Resource<List<Game>>>

    suspend fun setIsFavorites(isFavorites: Boolean, id: Long)

    fun getBookmarkedGames(): Flow<List<Game>>

    fun getGameDetails(id: Long): Flow<Resource<Game>>

    fun fetchGameTrailer(id: Long): Flow<Resource<Game>>

    fun searchGames(query: String): Flow<Resource<List<Game>>>

}