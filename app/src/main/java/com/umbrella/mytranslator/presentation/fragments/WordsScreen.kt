package com.umbrella.mytranslator.presentation.fragments

import com.umbrella.mytranslator.domain.entity.Word

interface WordsScreen {

    fun showWordsList(words: List<Word>)

    fun showErrorMessage(errorMessage: String?)

    fun showLoadingBar()

    fun hideLoadingBar()
}