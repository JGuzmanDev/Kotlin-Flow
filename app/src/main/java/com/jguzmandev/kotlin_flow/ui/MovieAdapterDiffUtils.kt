package com.jguzmandev.kotlin_flow.ui

import androidx.recyclerview.widget.DiffUtil
import com.jguzmandev.kotlin_flow.data.remote.entity.MovieRemote
import com.jguzmandev.kotlin_flow.usecase.domain.Movie

class MovieAdapterDiffUtils constructor(
    private val oldMoviesList: List<Movie>,
    private val newMoviesList: List<Movie>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldMoviesList.size

    override fun getNewListSize(): Int = newMoviesList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldMoviesList[oldItemPosition] == newMoviesList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldMoviesList[oldItemPosition] == newMoviesList[newItemPosition]


    companion object {
        fun newInstance(
            oldMoviesList: List<Movie>,
            newMoviesList: List<Movie>
        ) = MovieAdapterDiffUtils(
            oldMoviesList = oldMoviesList,
            newMoviesList = newMoviesList
        )
    }
}