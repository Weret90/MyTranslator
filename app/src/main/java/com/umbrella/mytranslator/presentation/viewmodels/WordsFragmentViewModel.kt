package com.umbrella.mytranslator.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.umbrella.mytranslator.domain.entity.Word
import com.umbrella.mytranslator.domain.usecase.GetWordsListUseCase

class WordsFragmentViewModel(
    private val getWordsListUseCase: GetWordsListUseCase
) : ViewModel() {

    private val _wordsList = MutableLiveData<List<Word>>()
    val wordsList: LiveData<List<Word>> = _wordsList

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun getWordsList(word: String) {
        if (word != "") {
            _loading.value = true
            getWordsListUseCase(word).subscribe(
                {
                    _wordsList.value = it
                    _loading.value = false
                },
                {
                    _errorMessage.value = it.message
                    _loading.value = false
                }
            )
        } else {
            _errorMessage.value = SEARCHING_WORD_EMPTY_VALUE
        }
    }

    fun clearErrorLiveData() {
        _errorMessage.value = null
    }

    companion object {
        private const val SEARCHING_WORD_EMPTY_VALUE = "Пустое значение искомого слова"
    }
}