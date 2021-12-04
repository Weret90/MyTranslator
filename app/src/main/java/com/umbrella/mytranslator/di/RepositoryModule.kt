package com.umbrella.mytranslator.di

import com.umbrella.mytranslator.data.repository.WordsRepositoryImpl
import com.umbrella.mytranslator.domain.repository.WordsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindWordsRepository(impl: WordsRepositoryImpl): WordsRepository
}