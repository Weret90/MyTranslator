package com.umbrella.mytranslator.di

import com.umbrella.mytranslator.presentation.fragments.WordFullMeaningFragment
import com.umbrella.mytranslator.presentation.fragments.WordsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class, RetrofitModule::class])
interface AppComponent {

    fun inject(wordsFragment: WordsFragment)
    fun inject(wordFullMeaningFragment: WordFullMeaningFragment)
}