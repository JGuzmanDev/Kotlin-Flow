package com.jguzmandev.kotlin_flow.data

import com.jguzmandev.kotlin_flow.data.local.LocalDataSource
import com.jguzmandev.kotlin_flow.data.remote.RemoteDataSource
import com.jguzmandev.kotlin_flow.usecase.domain.Movie
import kotlinx.coroutines.flow.Flow


class MovieRepository constructor(
    private val remoteMovieDataSource: RemoteDataSource,
    private val localMovieDataSource: LocalDataSource
) {

    suspend fun getAllMovies(): Flow<List<Movie>> {

        if (localMovieDataSource.isEmpty()) {
            val movies = remoteMovieDataSource.getMovies()
            localMovieDataSource.insertMovies(movies)
        }
        return localMovieDataSource.getAllMovies()
    }
}