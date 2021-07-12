package com.panda.abakasha_movies.presentation.movies_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.panda.abakasha_movies.domain.usecase.GetMoviesUseCase

//ViewModel factory class for getting the viewmodel
class MovieListViewModelFactory( private val getMoviesUseCase: GetMoviesUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieListViewModel(getMoviesUseCase) as T
    }
}