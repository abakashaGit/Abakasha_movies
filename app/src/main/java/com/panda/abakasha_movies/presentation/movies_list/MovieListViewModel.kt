package com.panda.abakasha_movies.presentation.movies_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.panda.abakasha_movies.domain.usecase.GetMoviesUseCase

class MovieListViewModel(private val getMoviesUseCase: GetMoviesUseCase): ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.getMovies()
        emit(movieList)
    }

}