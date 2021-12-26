package com.umbrella.mytranslator.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umbrella.mytranslator.domain.usecase.DeleteAllWordsInDbUseCase
import com.umbrella.mytranslator.domain.usecase.GetAllWordsFromDbUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HistoryViewModel(
    private val deleteAllWordsInDbUseCase: DeleteAllWordsInDbUseCase,
    getAllWordsFromDbUseCase: GetAllWordsFromDbUseCase,
) : ViewModel() {

    val historyLiveData = getAllWordsFromDbUseCase()

    fun deleteAllWords() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteAllWordsInDbUseCase()
        }
    }
}