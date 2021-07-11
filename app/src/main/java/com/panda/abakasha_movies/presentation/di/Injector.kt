package com.panda.abakasha_movies.presentation.di

import com.panda.abakasha_movies.presentation.di.movies.MovieSubComponent

interface Injector {

    fun createMovieSubComponent():MovieSubComponent
}