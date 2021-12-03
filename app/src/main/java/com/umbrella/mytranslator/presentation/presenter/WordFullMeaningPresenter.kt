package com.umbrella.mytranslator.presentation.presenter

import com.umbrella.mytranslator.domain.usecase.GetDetailMeaningUseCase
import com.umbrella.mytranslator.presentation.fragments.WordFullMeaningScreen

class WordFullMeaningPresenter(
    private val getDetailMeaningUseCase: GetDetailMeaningUseCase,
) {
    private var screen: WordFullMeaningScreen? = null

    fun attachScreen(screen: WordFullMeaningScreen) {
        if (this.screen != screen) {
            this.screen = screen
        }
    }

    fun detachScreen(screen: WordFullMeaningScreen) {
        if (this.screen == screen) {
            this.screen = null
        }
    }

    fun getFullMeaning(meaningId: String) {
        if (meaningId != "") {
            screen?.showLoadingBar()
            getDetailMeaningUseCase(meaningId).subscribe(
                {
                    screen?.hideLoadingBar()
                    screen?.showFullMeaning(it[0])
                },
                {
                    screen?.hideLoadingBar()
                    screen?.showErrorMessage(it.message)
                }
            )
        } else {
            screen?.showErrorMessage(MEANING_ID_EMPTY_VALUE)
        }
    }

    companion object {
        private const val MEANING_ID_EMPTY_VALUE = "Пустое id для meaning"
    }
}