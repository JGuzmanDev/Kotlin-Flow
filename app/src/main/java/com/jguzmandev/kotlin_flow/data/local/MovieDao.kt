package com.jguzmandev.kotlin_flow.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    fun insertMovies(movies:List<MovieEntity>)

    @Query("SELECT * FROM Movies")
    fun getAllMovies():Flow<List<MovieEntity>>

    @Delete
    @Transaction
    fun deleteAll(movies: List<MovieEntity>)

    @Query("SELECT count(MovieId) <= 0 FROM Movies ")
    fun isEmpty(): Boolean


}