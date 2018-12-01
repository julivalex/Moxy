package com.kotlin.note.example_6.di

import com.kotlin.note.example_6.CounterPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(presenter: CounterPresenter)
}