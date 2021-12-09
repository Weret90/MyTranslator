package com.umbrella.mytranslator.di

import com.umbrella.mytranslator.domain.usecase.GetDetailMeaningUseCase
import com.umbrella.mytranslator.domain.usecase.GetWordsListUseCase
import org.koin.dsl.module

val getWordsListIseCaseModule = module {
    factory {
        GetWordsListUseCase(repository = get())
    }
}

val getDetailMeaningUseCaseModule = module {
    factory {
        GetDetailMeaningUseCase(repository = get())
    }
}