package com.panda.abakasha_movies.presentation.di.movies

import com.panda.abakasha_movies.domain.usecase.GetMoviesUseCase
import com.panda.abakasha_movies.presentation.movies_list.MovieListViewModelFactory
import dagger.Module
import dagger.Provides
//Movie module for providing the ViewModel factory method
@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(getMoviesUseCase: GetMoviesUseCase): MovieListViewModelFactory {
        return MovieListViewModelFactory(getMoviesUseCase)
    }

}