package com.umbrella.mytranslator.di

import com.umbrella.mytranslator.presentation.viewmodels.HistoryViewModel
import com.umbrella.mytranslator.presentation.viewmodels.WordFullMeaningViewModel
import com.umbrella.mytranslator.presentation.viewmodels.WordsFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel {
        WordsFragmentViewModel(getWordsListUseCase = get())
    }

    viewModel {
        WordFullMeaningViewModel(getDetailMeaningUseCase = get())
    }

    viewModel {
        HistoryViewModel(get(), get())
    }
}