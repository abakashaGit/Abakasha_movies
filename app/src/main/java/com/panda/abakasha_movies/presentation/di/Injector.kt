package com.panda.abakasha_movies.presentation.di

import com.panda.abakasha_movies.presentation.di.movies.MovieSubComponent
/*
    -Injector interface for creating SubComponents
    -If we have multiple sub component then we can create multiple methods
 */
interface Injector {

    fun createMovieSubComponent():MovieSubComponent
}