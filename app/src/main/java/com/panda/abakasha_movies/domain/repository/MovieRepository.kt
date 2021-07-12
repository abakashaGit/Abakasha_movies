package com.panda.abakasha_movies.domain.repository

import com.panda.abakasha_movies.data.model.MoviesData
import com.panda.abakasha_movies.data.model.Results
// repository interface for domain layer communication
interface MovieRepository {
    suspend fun getMovies():List<Results>?
}