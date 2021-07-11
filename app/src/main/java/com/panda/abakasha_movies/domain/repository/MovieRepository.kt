package com.panda.abakasha_movies.domain.repository

import com.panda.abakasha_movies.data.model.MoviesData
import com.panda.abakasha_movies.data.model.Results

interface MovieRepository {
    suspend fun getMovies():List<Results>?
}