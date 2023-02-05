package com.katerina.morozova.core.room.daos

import androidx.room.*
import com.katerina.morozova.core.room.entities.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies")
    fun getAllMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movies")
    fun getAllMoviesList(): List<MovieEntity>

    @Delete
    suspend fun deleteMovie(movie: MovieEntity)

    @Insert
    suspend fun insertMovie(movie: MovieEntity)
}
