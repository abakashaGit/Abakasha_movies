package com.panda.abakasha_movies.presentation

import android.app.Application
import com.panda.abakasha_movies.presentation.di.Injector
import com.panda.abakasha_movies.presentation.di.core.*
import com.panda.abakasha_movies.presentation.di.movies.MovieSubComponent
/*
    - application class for initializing the DaggerAppComponet.
    - which implement the Injector interface
    - override the create mothode for providing MovieSubComponent
 */
class App:Application(),Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule("https://api.nytimes.com"))
            .remoteDataModule(RemoteDataModule("","VC2SwxZnwegWxsC2r5nyAGbRAsNruuao"))
            .build()
        

    }
    override fun createMovieSubComponent(): MovieSubComponent {
       return appComponent.movieSubComponent().create()
    }
}