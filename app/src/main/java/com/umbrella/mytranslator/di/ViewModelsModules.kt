package com.umbrella.mytranslator.di

import com.umbrella.mytranslator.presentation.viewmodels.WordFullMeaningViewModel
import com.umbrella.mytranslator.presentation.viewmodels.WordsFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val wordsFragmentViewModelModule = module {
    viewModel {
        WordsFragmentViewModel(getWordsListUseCase = get())
    }
}

val wordFullMeaningViewModelModule = module {
    viewModel {
        WordFullMeaningViewModel(getDetailMeaningUseCase = get())
    }
}