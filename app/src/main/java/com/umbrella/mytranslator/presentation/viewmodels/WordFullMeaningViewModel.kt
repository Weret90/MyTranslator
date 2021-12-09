package com.umbrella.mytranslator.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.umbrella.mytranslator.domain.entity.DetailMeaning
import com.umbrella.mytranslator.domain.usecase.GetDetailMeaningUseCase

class WordFullMeaningViewModel(
    private val getDetailMeaningUseCase: GetDetailMeaningUseCase
) : ViewModel() {

    private val _detailMeaning = MutableLiveData<DetailMeaning>()
    val detailMeaning: LiveData<DetailMeaning> = _detailMeaning

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun getFullMeaning(meaningId: String) {
        if (meaningId != "") {
            _loading.value = true
            getDetailMeaningUseCase(meaningId).subscribe(
                {
                    _loading.value = false
                    _detailMeaning.value = it[0]
                },
                {
                    _loading.value = false
                    _errorMessage.value = it.message
                }
            )
        } else {
            _errorMessage.value = MEANING_ID_EMPTY_VALUE
        }
    }

    fun clearErrorLiveData() {
        _errorMessage.value = null
    }

    companion object {
        private const val MEANING_ID_EMPTY_VALUE = "Пустое id для meaning"
    }
}