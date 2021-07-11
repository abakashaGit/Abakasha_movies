package com.panda.abakasha_movies.presentation.di.core

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideApplicationContext():Context{
        return context.applicationContext
    }

}