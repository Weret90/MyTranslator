package com.umbrella.mytranslator.presentation

import android.app.Application
import com.umbrella.mytranslator.di.AppComponent
import com.umbrella.mytranslator.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}