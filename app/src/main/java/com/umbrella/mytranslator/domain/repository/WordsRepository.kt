package com.umbrella.mytranslator.domain.repository

import androidx.lifecycle.LiveData
import com.umbrella.mytranslator.domain.entity.DetailMeaning
import com.umbrella.mytranslator.domain.entity.SimpleWord
import com.umbrella.mytranslator.domain.entity.Word

interface WordsRepository {
    suspend fun getWordsWithMeaningsByWord(word: String): List<Word>
    suspend fun getDetailMeaningByMeaningId(meaningId: String): List<DetailMeaning>
    fun getWordsFromDB(): LiveData<List<SimpleWord>>
    suspend fun deleteAllWordsInDB()
}