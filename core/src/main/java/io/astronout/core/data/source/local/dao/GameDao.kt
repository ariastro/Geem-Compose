package io.astronout.core.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import io.astronout.core.data.source.local.entity.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGames(games: List<GameEntity>)

    @Update
    fun updateGame(game: GameEntity)

    @Query("SELECT * FROM game")
    fun getAllGames(): Flow<List<GameEntity>>

    @Query("SELECT * FROM game WHERE name LIKE '%' || :query || '%'")
    fun searchGames(query: String): Flow<List<GameEntity>>

    @Query("SELECT * FROM game WHERE id = :id")
    fun getGameDetails(id: Long): Flow<GameEntity?>

    @Query("UPDATE game SET is_favorites = :isFavorites WHERE id = :id")
    suspend fun setIsFavorites(isFavorites: Boolean, id: Long)

    @Query("SELECT * FROM game WHERE is_favorites = 1")
    fun getAllFavoriteGames(): Flow<List<GameEntity>>
}