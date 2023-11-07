package io.astronout.core.domain.repository

import io.astronout.core.domain.model.Game
import io.astronout.core.vo.Resource
import kotlinx.coroutines.flow.Flow

interface GamesRepository {
    fun getAllGames(): Flow<Resource<List<Game>>>
    fun searchGames(query: String): Flow<Resource<List<Game>>>
    suspend fun setIsFavorites(isFavorites: Boolean, id: Long)
    fun getAllFavoritesGames(): Flow<List<Game>>
    fun getGameDetails(id: Long): Flow<Game>
}
