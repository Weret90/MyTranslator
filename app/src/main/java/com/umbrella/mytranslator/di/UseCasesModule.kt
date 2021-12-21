package com.umbrella.mytranslator.di

import com.umbrella.mytranslator.domain.usecase.DeleteAllWordsInDbUseCase
import com.umbrella.mytranslator.domain.usecase.GetAllWordsFromDbUseCase
import com.umbrella.mytranslator.domain.usecase.GetDetailMeaningUseCase
import com.umbrella.mytranslator.domain.usecase.GetWordsListUseCase
import org.koin.dsl.module

val useCasesModule = module {
    factory {
        GetWordsListUseCase(repository = get())
    }

    factory {
        GetDetailMeaningUseCase(repository = get())
    }

    factory {
        DeleteAllWordsInDbUseCase(repository = get())
    }

    factory {
        GetAllWordsFromDbUseCase(repository = get())
    }
}