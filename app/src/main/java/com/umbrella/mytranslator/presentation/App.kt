package com.umbrella.mytranslator.presentation

import android.app.Application
import com.umbrella.mytranslator.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                repositoryModule,
                retrofitModule,
                viewModelsModule,
                roomModule
            )
        }
    }
}