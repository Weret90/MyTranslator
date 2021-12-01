package com.umbrella.mytranslator.presentation.fragments

import com.umbrella.mytranslator.domain.entity.DetailMeaning

interface WordFullMeaningScreen {

    fun showFullMeaning(fullMeaning: DetailMeaning)

    fun showErrorMessage(errorMessage: String?)

    fun showLoadingBar()

    fun hideLoadingBar()
}