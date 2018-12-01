package com.kotlin.note.example_6.di

import com.kotlin.note.example_6.mvp.CounterInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideCounterInteractor(): CounterInteractor {
        return CounterInteractor()
    }
}