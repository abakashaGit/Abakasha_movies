package com.panda.abakasha_movies.presentation.di.core

import com.panda.abakasha_movies.presentation.di.movies.MovieSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        RepositoryModule::class,
        NetModule::class,
        RemoteDataModule::class,
        UseCaseModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {
    fun movieSubComponent():MovieSubComponent.Factory
}