package com.panda.abakasha_movies.data.repository.datasource

import com.panda.abakasha_movies.data.model.MoviesData
import retrofit2.Response
/*
    -Data source for getting the data from the api
    -If we have multiple data source then we can create multiple data source
    like MovieCacheDataSource, MovieLocalDataSource
 */
interface MovieRemoteDataSource {
    suspend fun getMovies():Response<MoviesData>
}