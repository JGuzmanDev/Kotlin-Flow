package com.jguzmandev.kotlin_flow.usecase

import com.jguzmandev.kotlin_flow.data.MovieRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class GetMovies constructor(private val movieRepository: MovieRepository) {

    suspend fun invoke() = flow {
        movieRepository.getAllMovies().collect {
            emit(it)
        }
    }
}