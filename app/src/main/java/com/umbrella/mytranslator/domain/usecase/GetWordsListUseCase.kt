package com.umbrella.mytranslator.domain.usecase

import com.umbrella.mytranslator.domain.entity.Word
import com.umbrella.mytranslator.domain.repository.WordsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetWordsListUseCase @Inject constructor(private val repository: WordsRepository) {

    operator fun invoke(word: String): Single<List<Word>> {
        return repository.getWordsWithMeaningsByWord(word)
    }
}