package com.panda.abakasha_movies.domain.usecase

import com.panda.abakasha_movies.data.model.Results
import com.panda.abakasha_movies.domain.repository.MovieRepository

//Usecase class for get movies from api
class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun getMovies():List<Results>?{
        return movieRepository.getMovies()
    }
}