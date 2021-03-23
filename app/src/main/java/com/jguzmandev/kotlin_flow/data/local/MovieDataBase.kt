package com.jguzmandev.kotlin_flow.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jguzmandev.kotlin_flow.helpers.Constant

@Database(
    entities = [MovieEntity::class],
    version = 1
)
abstract class MovieDataBase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        private var INSTANCE: MovieDataBase? = null

        fun getMovieLocalService(context: Context): MovieDataBase {
            return INSTANCE ?: buildDataBase(context).also { INSTANCE = it }
        }

        private fun buildDataBase(context: Context): MovieDataBase {
            return Room.databaseBuilder(
                context,
                MovieDataBase::class.java,
                Constant.ROOM_DATABASE_NAME
            ).build()

        }
    }
}