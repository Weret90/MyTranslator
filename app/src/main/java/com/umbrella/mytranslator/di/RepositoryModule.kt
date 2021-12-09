package com.umbrella.mytranslator.di

import com.umbrella.mytranslator.data.repository.WordsRepositoryImpl
import com.umbrella.mytranslator.domain.repository.WordsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<WordsRepository> {
        WordsRepositoryImpl(api = get())
    }
}