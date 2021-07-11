package com.panda.abakasha_movies.presentation.di.core

import com.panda.abakasha_movies.data.api.MovieApiService
import com.panda.abakasha_movies.data.repository.datasource.MovieRemoteDataSource
import com.panda.abakasha_movies.data.repository.datasourceimpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(
    private val critic: String,
    private val apiKey: String
) {

    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(movieApiService: MovieApiService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(movieApiService,critic,apiKey)

    }
}