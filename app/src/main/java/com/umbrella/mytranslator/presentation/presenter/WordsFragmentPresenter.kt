package com.umbrella.mytranslator.presentation.presenter

import com.umbrella.mytranslator.domain.usecase.GetWordsListUseCase
import com.umbrella.mytranslator.presentation.fragments.WordsScreen

class WordsFragmentPresenter(
    private val getWordsListUseCase: GetWordsListUseCase,
) {
    private var screen: WordsScreen? = null

    fun attachScreen(screen: WordsScreen) {
        if (this.screen != screen) {
            this.screen = screen
        }
    }

    fun detachScreen(screen: WordsScreen) {
        if (this.screen == screen) {
            this.screen = null
        }
    }

    fun getWordsList(word: String) {
        if (word != "") {
            screen?.showLoadingBar()
            getWordsListUseCase(word).subscribe(
                {
                    screen?.showWordsList(it)
                    screen?.hideLoadingBar()
                },
                {
                    screen?.showErrorMessage(it.message)
                    screen?.hideLoadingBar()
                }
            )
        } else {
            screen?.showErrorMessage(SEARCHING_WORD_EMPTY_VALUE)
        }
    }

    companion object {
        private const val SEARCHING_WORD_EMPTY_VALUE = "Пустое значение искомого слова"
    }
}