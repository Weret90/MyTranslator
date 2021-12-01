package com.umbrella.mytranslator.presentation.presenter

import com.umbrella.mytranslator.presentation.fragments.SearchDialogScreen

class SearchDialogPresenter {

    private var screen: SearchDialogScreen? = null

    fun attachScreen(screen: SearchDialogScreen) {
        if (this.screen != screen) {
            this.screen = screen
        }
    }

    fun detachScreen(screen: SearchDialogScreen) {
        if (this.screen == screen) {
            this.screen = null
        }
    }

    fun parseWord(word: String) {
        if (word.isNotBlank()) {
            screen?.goToScreenWithWords(word)
        } else {
            screen?.showErrorMessage(SEARCHING_WORD_EMPTY_VALUE)
        }
    }

    companion object {
        private const val SEARCHING_WORD_EMPTY_VALUE = "Введите хоть что-то"
    }
}