package com.umbrella.mytranslator.domain.usecase

import androidx.lifecycle.LiveData
import com.umbrella.mytranslator.domain.entity.SimpleWord
import com.umbrella.mytranslator.domain.repository.WordsRepository

class GetAllWordsFromDbUseCase(private val repository: WordsRepository) {

     operator fun invoke(): LiveData<List<SimpleWord>> {
        return repository.getWordsFromDB()
    }
}