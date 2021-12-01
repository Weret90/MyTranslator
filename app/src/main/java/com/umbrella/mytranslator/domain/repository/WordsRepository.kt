package com.umbrella.mytranslator.domain.repository

import com.umbrella.mytranslator.domain.entity.DetailMeaning
import com.umbrella.mytranslator.domain.entity.Word
import io.reactivex.rxjava3.core.Single

interface WordsRepository {

    fun getWordsWithMeaningsByWord(word: String): Single<List<Word>>

    fun getDetailMeaningByMeaningId(meaningId: String): Single<List<DetailMeaning>>
}