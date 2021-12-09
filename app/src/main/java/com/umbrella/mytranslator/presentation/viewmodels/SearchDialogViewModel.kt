package com.umbrella.mytranslator.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchDialogViewModel : ViewModel() {

    private val _navigateToWordsFragment = MutableLiveData<String>()
    val navigateToWordsFragment: LiveData<String> = _navigateToWordsFragment

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun parseWord(word: String) {
        if (word.isNotBlank()) {
            _navigateToWordsFragment.value = word
        } else {
            _errorMessage.value = SEARCHING_WORD_EMPTY_VALUE
        }
    }

    fun clearErrorLiveData() {
        _errorMessage.value = null
    }

    fun clearNavigateToWordsFragmentLiveData() {
        _navigateToWordsFragment.value = null
    }

    companion object {
        private const val SEARCHING_WORD_EMPTY_VALUE = "Введите хоть что-то"
    }
}