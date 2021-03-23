package com.jguzmandev.kotlin_flow.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.jguzmandev.kotlin_flow.app.AppInitialize
import com.jguzmandev.kotlin_flow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val movieAdapter by lazy { MovieAdapter(this) }

    private val viewModelFactory by lazy { MainViewModelFactory(initGetMovieUseCase()) }
    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvMovies.adapter = movieAdapter

        viewModel.movieRemoteLiveData.observe(this) {
            val movies = it.shuffled()
            movieAdapter.addMovies(movies)
        }

        viewModel.getMovies()
    }

    private fun initGetMovieUseCase() =
        (application as AppInitialize).injector.getMovieUseCase
}