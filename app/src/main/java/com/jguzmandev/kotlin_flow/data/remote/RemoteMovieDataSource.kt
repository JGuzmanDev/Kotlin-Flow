package com.jguzmandev.kotlin_flow.data.remote

import com.jguzmandev.kotlin_flow.helpers.toDomainMovie
import com.jguzmandev.kotlin_flow.usecase.domain.Movie

class RemoteMovieDataSource(private val movieService: MovieApi) : RemoteDataSource {

    override suspend fun getMovies(): List<Movie>{
        return movieService.getMovies().movieRemotes.map { it.toDomainMovie() }
    }


}

interface RemoteDataSource{
    suspend fun getMovies():List<Movie>
}