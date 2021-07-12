package com.panda.abakasha_movies.presentation.movies_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.panda.abakasha_movies.domain.usecase.GetMoviesUseCase

//ViewModel class for Fragment to hold view related data.
class MovieListViewModel(private val getMoviesUseCase: GetMoviesUseCase): ViewModel() {
    //gets the list of movies from usecase and emit which is observed inside fragment
    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.getMovies()
        emit(movieList)
    }

}