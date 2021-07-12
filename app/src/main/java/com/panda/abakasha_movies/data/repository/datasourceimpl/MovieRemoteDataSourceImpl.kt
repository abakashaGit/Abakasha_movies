package com.panda.abakasha_movies.data.repository.datasourceimpl

import com.panda.abakasha_movies.data.api.MovieApiService
import com.panda.abakasha_movies.data.model.MoviesData
import com.panda.abakasha_movies.data.repository.datasource.MovieRemoteDataSource
import retrofit2.Response

// Data source implementation classes.
class MovieRemoteDataSourceImpl(private val movieApiService: MovieApiService,
                                private val critic:String,
                                private val apiKey:String): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MoviesData> {
        return movieApiService.getMovies(critic,apiKey)
    }
}