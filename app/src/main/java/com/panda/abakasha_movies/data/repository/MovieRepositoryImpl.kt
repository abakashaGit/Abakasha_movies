package com.panda.abakasha_movies.data.repository

import com.panda.abakasha_movies.data.model.MoviesData
import com.panda.abakasha_movies.data.model.Results
import com.panda.abakasha_movies.data.repository.datasource.MovieRemoteDataSource
import com.panda.abakasha_movies.domain.repository.MovieRepository
import retrofit2.Response
import java.lang.Exception

/*
    -Repository implementation class for getting the response from the data source
    -If we have multiple data source then we can pass multiple datasource in primary constructor
 */
class MovieRepositoryImpl(private val remoteDataSource: MovieRemoteDataSource):MovieRepository {
    override suspend fun getMovies(): List<Results>? {
        lateinit var movieList: List<Results>
        try {
            val response: Response<MoviesData> = remoteDataSource.getMovies()
            val body = response.body()
            body?.let {
                movieList = it.results
            }
        }catch (e: Exception){

        }
        return movieList
    }
}