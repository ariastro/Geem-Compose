package io.astronout.core.data.source.local

import io.astronout.core.data.source.local.entity.GameEntity
import io.astronout.core.data.source.local.room.GameDatabase
import io.astronout.core.data.source.remote.model.GameRequest
import io.astronout.core.utils.getLastMonthDate
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val appDatabase: GameDatabase
) : LocalDataSource {

    override fun getAllGames(): Flow<List<GameEntity>> {
        return appDatabase.gameDao().getAllGames()
    }

    override fun getHotGames(): Flow<List<GameEntity>> {
        return appDatabase.gameDao().getHotGames(getLastMonthDate())
    }

    override fun searchGames(query: String): Flow<List<GameEntity>> {
        return appDatabase.gameDao().searchGames(query)
    }

    override fun getGameDetail(id: Long): Flow<GameEntity?> {
        return appDatabase.gameDao().getGameDetails(id)
    }

    override suspend fun setIsFavorites(isFavorites: Boolean, id: Long) {
        appDatabase.gameDao().setIsFavorites(isFavorites, id)
    }

    override fun getAllFavoriteGames(): Flow<List<GameEntity>> {
        return appDatabase.gameDao().getAllFavoriteGames()
    }

    override suspend fun insertGames(games: List<GameEntity>) {
        appDatabase.gameDao().insertGames(games)
    }

    override suspend fun updateGameDescription(id: Long, description: String) {
        appDatabase.gameDao().updateGameDescription(id, description)
    }

    override suspend fun updateGameTrailer(id: Long, trailerUrl: String) {
        appDatabase.gameDao().updateGameTrailer(id, trailerUrl)
    }
}