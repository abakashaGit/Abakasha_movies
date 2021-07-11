package com.panda.abakasha_movies.data.repository.datasource

import com.panda.abakasha_movies.data.model.MoviesData
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies():Response<MoviesData>
}