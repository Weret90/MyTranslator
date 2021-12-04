package com.umbrella.mytranslator.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.umbrella.mytranslator.domain.usecase.GetDetailMeaningUseCase

class WordFullMeaningViewModelFactory(
    private val getDetailMeaningUseCase: GetDetailMeaningUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WordFullMeaningViewModel(getDetailMeaningUseCase) as T
    }
}