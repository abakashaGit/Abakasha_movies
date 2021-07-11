package com.panda.abakasha_movies.data.api

import com.panda.abakasha_movies.data.model.MoviesData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("/svc/movies/v2/reviews/search.json")
    suspend fun getMovies(
            @Query("query")
            critic:String,
            @Query("api-key")
            apiKey: String): Response<MoviesData>
}