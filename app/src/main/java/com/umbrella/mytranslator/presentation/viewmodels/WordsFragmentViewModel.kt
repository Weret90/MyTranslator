package com.umbrella.mytranslator.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umbrella.mytranslator.domain.entity.Word
import com.umbrella.mytranslator.domain.usecase.GetWordsListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class WordsFragmentViewModel(
    private val getWordsListUseCase: GetWordsListUseCase,
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
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val wordsList = getWordsListUseCase(word)
                    withContext(Dispatchers.Main) {
                        _wordsList.value = wordsList
                        _loading.value = false
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        _errorMessage.value = e.message
                        _loading.value = false
                    }
                }
            }
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