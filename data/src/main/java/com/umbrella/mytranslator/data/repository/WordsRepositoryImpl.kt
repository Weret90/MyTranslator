package com.umbrella.mytranslator.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.umbrella.mytranslator.data.database.WordsDao
import com.umbrella.mytranslator.data.mapper.toDomainModel
import com.umbrella.mytranslator.data.model.database.SimpleWordDatabaseModel
import com.umbrella.mytranslator.data.network.RetrofitService
import com.umbrella.mytranslator.domain.entity.DetailMeaning
import com.umbrella.mytranslator.domain.entity.SimpleWord
import com.umbrella.mytranslator.domain.entity.Word
import com.umbrella.mytranslator.domain.repository.WordsRepository

class WordsRepositoryImpl(
    private val api: RetrofitService,
    private val dao: WordsDao
) : WordsRepository {

    override suspend fun getWordsWithMeaningsByWord(word: String): List<Word> {
        dao.insertWord(SimpleWordDatabaseModel(word))
        return api.getWordsByWord(word)
            .map { it.toDomainModel() }
    }

    override suspend fun getDetailMeaningByMeaningId(meaningId: String): List<DetailMeaning> {
        return api.getDetailMeaningById(meaningId)
            .map { it.toDomainModel() }
    }

    override fun getWordsFromDB(): LiveData<List<SimpleWord>> {
        return Transformations.map(dao.getAllWords()) { list ->
            list.map { it.toDomainModel() }
        }
    }

    override suspend fun deleteAllWordsInDB() {
        dao.deleteAllWords()
    }
}