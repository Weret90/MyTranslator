package com.umbrella.mytranslator.domain.usecase

import com.umbrella.mytranslator.domain.repository.WordsRepository

class DeleteAllWordsInDbUseCase(private val repository: WordsRepository) {

    suspend operator fun invoke() {
        repository.deleteAllWordsInDB()
    }
}