package com.kotlin.note.example_6

import android.app.Application
import com.kotlin.note.example_6.di.AppComponent
import com.kotlin.note.example_6.di.DaggerAppComponent

class App : Application() {

    lateinit var component: AppComponent

    companion object {
        var appContext: App? = null
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.create()
        appContext = applicationContext as? App
    }
}