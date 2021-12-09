package com.umbrella.mytranslator.data.repository

import com.umbrella.mytranslator.data.mapper.toDomainModel
import com.umbrella.mytranslator.data.network.RetrofitService
import com.umbrella.mytranslator.domain.entity.DetailMeaning
import com.umbrella.mytranslator.domain.entity.Word
import com.umbrella.mytranslator.domain.repository.WordsRepository

class WordsRepositoryImpl(
    private val api: RetrofitService,
) : WordsRepository {

    override suspend fun getWordsWithMeaningsByWord(word: String): List<Word> {
        return api.getWordsByWord(word)
            .map { it.toDomainModel() }
    }

    override suspend fun getDetailMeaningByMeaningId(meaningId: String): List<DetailMeaning> {
        return api.getDetailMeaningById(meaningId)
            .map { it.toDomainModel() }
    }
}