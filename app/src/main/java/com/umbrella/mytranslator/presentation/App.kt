package com.umbrella.mytranslator.presentation

import android.app.Application
import com.umbrella.mytranslator.di.*
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                repositoryModule,
                retrofitModule,
                getWordsListIseCaseModule,
                getDetailMeaningUseCaseModule,
                wordsFragmentViewModelModule,
                wordFullMeaningViewModelModule
            )
        }
    }
}