package com.jguzmandev.kotlin_flow.data.remote

import com.jguzmandev.kotlin_flow.data.remote.entity.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("discover/movie")
    suspend fun getMovies(
        @Query("api_key") apiKey: String = "e25941f5bbafacdee32a5a99c64e6e92",
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("page") page: Int = 1
    ): MovieResponse

}