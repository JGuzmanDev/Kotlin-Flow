package com.jguzmandev.kotlin_flow.app

import android.content.Context
import com.jguzmandev.kotlin_flow.data.MovieRepository
import com.jguzmandev.kotlin_flow.data.local.LocalMovieDataSource
import com.jguzmandev.kotlin_flow.data.local.LocalMovieService
import com.jguzmandev.kotlin_flow.data.remote.RemoteMovieDataSource
import com.jguzmandev.kotlin_flow.data.remote.RemoteMovieService
import com.jguzmandev.kotlin_flow.usecase.GetMovies

class Injector constructor(private val context: Context) {
    //DataSource
    private val movieDAO by lazy { LocalMovieService.getLocalDatabaseService(context).movieDao() }
    private val movieApi by lazy { RemoteMovieService.getService() }

    private val localDataSource by lazy { LocalMovieDataSource(movieDAO) }
    private val remoteDataSource by lazy { RemoteMovieDataSource(movieApi) }

    //Repository
    private val movieRepository by lazy {MovieRepository(
        remoteMovieDataSource = remoteDataSource,
        localMovieDataSource = localDataSource
    )}

    //Use Case
    val getMovieUseCase  by lazy {GetMovies(movieRepository = movieRepository)}
}