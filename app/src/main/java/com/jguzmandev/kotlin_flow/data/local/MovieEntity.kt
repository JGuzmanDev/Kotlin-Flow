package com.jguzmandev.kotlin_flow.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Movies")
data class MovieEntity constructor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "MovieId")
    val id: Int,
    @ColumnInfo(name = "MovieTitle")
    val title: String,
    @ColumnInfo(name = "MoviePosterPath")
    val posterPath: String,
    @ColumnInfo(name = "MovieVoteAverage")
    val voteAverage: Double,
)