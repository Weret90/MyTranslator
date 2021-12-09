package com.umbrella.mytranslator.domain.repository

import com.umbrella.mytranslator.domain.entity.DetailMeaning
import com.umbrella.mytranslator.domain.entity.Word

interface WordsRepository {
    suspend fun getWordsWithMeaningsByWord(word: String): List<Word>
    suspend fun getDetailMeaningByMeaningId(meaningId: String): List<DetailMeaning>
}