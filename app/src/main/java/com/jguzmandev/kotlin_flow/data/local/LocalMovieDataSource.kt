package com.jguzmandev.kotlin_flow.data.local

import com.jguzmandev.kotlin_flow.helpers.toDomainMovie
import com.jguzmandev.kotlin_flow.helpers.toRoomMovie
import com.jguzmandev.kotlin_flow.usecase.domain.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalMovieDataSource constructor(private val movieDao: MovieDao) : LocalDataSource {
    override suspend fun insertMovies(movies: List<Movie>) {
        movieDao.insertMovies(movies = movies.map { it.toRoomMovie() })
    }

    override suspend fun getAllMovies(): Flow<List<Movie>> {
        return movieDao.getAllMovies().map { movie -> movie.map { it.toDomainMovie() } }
    }

    override suspend fun isEmpty(): Boolean = movieDao.isEmpty()
}

interface LocalDataSource {
    suspend fun insertMovies(movies: List<Movie>)
    suspend fun getAllMovies(): Flow<List<Movie>>
    suspend fun isEmpty():Boolean

}