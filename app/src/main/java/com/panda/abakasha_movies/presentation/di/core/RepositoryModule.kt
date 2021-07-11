package com.panda.abakasha_movies.presentation.di.core

import com.panda.abakasha_movies.data.repository.MovieRepositoryImpl
import com.panda.abakasha_movies.data.repository.datasource.MovieRemoteDataSource
import com.panda.abakasha_movies.data.repository.datasourceimpl.MovieRemoteDataSourceImpl
import com.panda.abakasha_movies.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDatasource)

    }
}