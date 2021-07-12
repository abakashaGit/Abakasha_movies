package com.panda.abakasha_movies.data.model

import java.io.Serializable
//Model classes for getting required fields from the json response
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

