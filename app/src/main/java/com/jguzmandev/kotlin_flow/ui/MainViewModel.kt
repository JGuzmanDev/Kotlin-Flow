package com.jguzmandev.kotlin_flow.ui

import androidx.lifecycle.*
import com.jguzmandev.kotlin_flow.usecase.GetMovies
import com.jguzmandev.kotlin_flow.usecase.domain.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel constructor(private val movies: GetMovies) : ViewModel() {

    private val _moviesLiveData: MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()
    val movieRemoteLiveData: LiveData<List<Movie>> = _moviesLiveData

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            movies.invoke().collect { movies ->
                _moviesLiveData.postValue(movies)
            }
        }
    }
}

class MainViewModelFactory constructor(private val movies: GetMovies) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(movies) as T
    }
}