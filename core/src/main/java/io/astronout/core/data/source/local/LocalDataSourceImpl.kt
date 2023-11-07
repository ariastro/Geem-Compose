package io.astronout.core.data.source.local

import io.astronout.core.data.source.local.entity.GameEntity
import io.astronout.core.data.source.local.room.GameDatabase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val appDatabase: GameDatabase
) : LocalDataSource {

    override fun getAllGames(): Flow<List<GameEntity>> {
        return appDatabase.gameDao().getAllGames()
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

    override suspend fun updateGame(game: GameEntity) {
        appDatabase.gameDao().updateGame(game)
    }
}