package com.jguzmandev.kotlin_flow.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jguzmandev.kotlin_flow.R
import com.jguzmandev.kotlin_flow.data.remote.entity.MovieRemote
import com.jguzmandev.kotlin_flow.databinding.MovieItemBinding
import com.jguzmandev.kotlin_flow.usecase.domain.Movie

class MovieAdapter constructor(private val context: Context) : RecyclerView.Adapter<MovieAdapter.MovieVH>() {

    private var movies = mutableListOf<Movie>()

    fun addMovies(movies:List<Movie>){
        val result = MovieAdapterDiffUtils.newInstance(this.movies,movies)

        DiffUtil.calculateDiff(result).also {
            it.dispatchUpdatesTo(this)
        }
        if(this.movies.isNotEmpty())this.movies.clear()
        this.movies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return MovieVH(binding)
    }

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = movies.size


    inner class MovieVH constructor(private val binding:MovieItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(movie:Movie){
            binding.tvTitle.text = movie.title
            Glide.with(context)
                .load("https://image.tmdb.org/t/p/original${movie.posterPath}")
                .placeholder(R.drawable.ic_loading_photo)
                .into(binding.ivCover)
        }
    }
}