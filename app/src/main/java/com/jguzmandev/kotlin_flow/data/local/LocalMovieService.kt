package com.jguzmandev.kotlin_flow.data.local

import android.content.Context

object LocalMovieService {

    fun getLocalDatabaseService(context: Context)
    = MovieDataBase.getMovieLocalService(context)
}