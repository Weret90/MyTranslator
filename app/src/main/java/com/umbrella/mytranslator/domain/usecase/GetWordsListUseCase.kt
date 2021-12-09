package com.umbrella.mytranslator.domain.usecase

import com.umbrella.mytranslator.domain.entity.Word
import com.umbrella.mytranslator.domain.repository.WordsRepository

class GetWordsListUseCase (private val repository: WordsRepository) {

    suspend operator fun invoke(word: String): List<Word> {
        return repository.getWordsWithMeaningsByWord(word)
    }
}