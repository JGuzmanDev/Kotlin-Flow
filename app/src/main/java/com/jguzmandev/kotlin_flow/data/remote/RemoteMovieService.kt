package com.jguzmandev.kotlin_flow.data.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RemoteMovieService {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl("https://api.themoviedb.org/3/")
        .build()


    fun getService(): MovieApi = retrofit.create(MovieApi::class.java)
}