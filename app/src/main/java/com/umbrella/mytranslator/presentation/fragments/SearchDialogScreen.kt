package com.umbrella.mytranslator.presentation.fragments

interface SearchDialogScreen {

    fun goToScreenWithWords(word: String)

    fun showErrorMessage(errorMessage: String)
}