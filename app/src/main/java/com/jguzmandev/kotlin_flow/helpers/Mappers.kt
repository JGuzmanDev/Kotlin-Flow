package com.jguzmandev.kotlin_flow.helpers

import com.jguzmandev.kotlin_flow.data.local.MovieEntity
import com.jguzmandev.kotlin_flow.data.remote.entity.MovieRemote
import com.jguzmandev.kotlin_flow.usecase.domain.Movie

fun MovieEntity.toDomainMovie() = Movie(
    title = this.title,
    posterPath = this.posterPath,
    voteAverage = this.voteAverage
)

fun Movie.toRoomMovie() = MovieEntity(
    id = 0,
    title = this.title,
    posterPath = this.posterPath,
    voteAverage = this.voteAverage
)

fun MovieRemote.toDomainMovie() = Movie(
    title = this.title,
    posterPath = this.posterPath,
    voteAverage = this.voteAverage
)