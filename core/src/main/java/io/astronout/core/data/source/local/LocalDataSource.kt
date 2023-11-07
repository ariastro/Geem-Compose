package io.astronout.core.data.source.local

import io.astronout.core.data.source.local.entity.GameEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getAllGames(): Flow<List<GameEntity>>
    fun searchGames(query: String): Flow<List<GameEntity>>
    fun getGameDetail(id: Long): Flow<GameEntity?>
    suspend fun setIsFavorites(isFavorites: Boolean, id: Long)
    fun getAllFavoriteGames(): Flow<List<GameEntity>>
    suspend fun insertGames(games: List<GameEntity>)
    suspend fun updateGame(game: GameEntity)

}