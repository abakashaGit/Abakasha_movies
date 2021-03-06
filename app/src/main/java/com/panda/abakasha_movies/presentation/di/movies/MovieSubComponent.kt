package com.panda.abakasha_movies.presentation.di.movies

import com.panda.abakasha_movies.presentation.movies_list.MovieListFragment
import dagger.Subcomponent

//Factory pattern for creating the MovieSubComponent
@MovieScope
@Subcomponent(modules =[MovieModule::class] )
interface MovieSubComponent {

    fun inject(movieListFragment: MovieListFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
}