package com.panda.abakasha_movies.data.model

import java.io.Serializable

data class MoviesData(
        val results: List<Results>
)

data class Results(
        val display_title: String,
        val multimedia: Multimedia,
        val summary_short: String
) : Serializable

data class Multimedia(
        val src : String
)

