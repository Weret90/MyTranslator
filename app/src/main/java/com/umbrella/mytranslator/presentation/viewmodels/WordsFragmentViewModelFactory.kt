package com.umbrella.mytranslator.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.umbrella.mytranslator.domain.usecase.GetWordsListUseCase
import javax.inject.Inject

class WordsFragmentViewModelFactory @Inject constructor(
    private val getWordsListUseCase: GetWordsListUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WordsFragmentViewModel(getWordsListUseCase) as T
    }
}