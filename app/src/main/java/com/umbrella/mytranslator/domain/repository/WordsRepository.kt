package com.umbrella.mytranslator.domain.repository

import com.umbrella.mytranslator.domain.entity.Meaning
import com.umbrella.mytranslator.domain.entity.Word
import io.reactivex.rxjava3.core.Single

interface WordsRepository {

    fun getWordsWithMeaningsByWord(word: String): Single<List<Word>>

    fun getDetailMeaningByMeaningId(meaningId: Long): Single<Meaning>
}