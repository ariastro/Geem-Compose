package io.astronout.core.data.source

import com.skydoves.sandwich.ApiResponse
import io.astronout.core.data.source.local.LocalDataSource
import io.astronout.core.data.source.local.entity.GameEntity
import io.astronout.core.data.source.remote.RemoteDataSource
import io.astronout.core.data.source.remote.model.GamesResponse
import io.astronout.core.domain.model.Game
import io.astronout.core.domain.repository.GamesRepository
import io.astronout.core.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GamesDataStore @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : GamesRepository {

    override fun getAllGames(): Flow<Resource<List<Game>>> =
        object : NetworkBoundResource<List<Game>, GamesResponse>() {
            override fun loadFromDB(): Flow<List<Game>> {
                return localDataSource.getAllGames().map { games ->
                    games.map { Game(it) }
                }
            }

            override fun shouldFetch(data: List<Game>?): Boolean =
                data.isNullOrEmpty()

            override suspend fun createCall(): ApiResponse<GamesResponse> =
                remoteDataSource.getAllGames()

            override suspend fun saveCallResult(data: GamesResponse) {
                localDataSource.insertGames(data.results?.map { GameEntity(it) }.orEmpty())
            }
        }.asFlow()

    override fun searchGames(query: String): Flow<Resource<List<Game>>> =
        object : NetworkBoundResource<List<Game>, GamesResponse>() {
            override fun loadFromDB(): Flow<List<Game>> {
                return localDataSource.searchGames(query).map { games ->
                    games.map { Game(it) }
                }
            }

            override fun shouldFetch(data: List<Game>?): Boolean =
                data.isNullOrEmpty()

            override suspend fun createCall(): ApiResponse<GamesResponse> =
                remoteDataSource.searchGames(query)

            override suspend fun saveCallResult(data: GamesResponse) {
                localDataSource.insertGames(data.results?.map { GameEntity(it) }.orEmpty())
            }
        }.asFlow()

    override suspend fun setIsFavorites(isFavorites: Boolean, id: Long) {
        localDataSource.setIsFavorites(isFavorites, id)
    }

    override fun getAllFavoritesGames(): Flow<List<Game>> {
        return localDataSource.getAllFavoriteGames().map { games ->
            games.map { Game(it) }
        }
    }

    override fun getGameDetails(id: Long): Flow<Game> {
        return localDataSource.getGameDetail(id).map { Game(it) }
    }
}
