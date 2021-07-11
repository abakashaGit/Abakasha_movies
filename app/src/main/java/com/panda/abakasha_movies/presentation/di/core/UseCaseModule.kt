package com.panda.abakasha_movies.presentation.di.core

import com.panda.abakasha_movies.domain.repository.MovieRepository
import com.panda.abakasha_movies.domain.usecase.GetMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }
}