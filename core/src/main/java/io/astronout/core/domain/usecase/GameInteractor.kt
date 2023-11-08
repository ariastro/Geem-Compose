package io.astronout.core.domain.usecase

import io.astronout.core.domain.model.Game
import io.astronout.core.domain.repository.GamesRepository
import io.astronout.core.vo.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameInteractor @Inject constructor(private val repo: GamesRepository) : GameUsecase {

    override fun getAllGames(): Flow<Resource<List<Game>>> {
        return repo.getAllGames()
    }

    override fun getHotGames(): Flow<Resource<List<Game>>> {
        return repo.getHotGames()
    }

    override suspend fun setIsFavorites(isFavorites: Boolean, id: Long) {
        repo.setIsFavorites(isFavorites, id)
    }

    override fun getAllFavoritesGames(): Flow<List<Game>> {
        return repo.getAllFavoritesGames()
    }

    override fun getGameDetails(id: Long): Flow<Resource<Game>> {
        return repo.getGameDetails(id)
    }

}