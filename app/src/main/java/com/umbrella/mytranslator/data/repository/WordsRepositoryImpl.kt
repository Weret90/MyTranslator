package com.umbrella.mytranslator.data.repository

import com.umbrella.mytranslator.data.mapper.toDomainModel
import com.umbrella.mytranslator.data.network.RetrofitService
import com.umbrella.mytranslator.domain.entity.DetailMeaning
import com.umbrella.mytranslator.domain.entity.Word
import com.umbrella.mytranslator.domain.repository.WordsRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class WordsRepositoryImpl(
    private val api: RetrofitService,
) : WordsRepository {

    override fun getWordsWithMeaningsByWord(word: String): Single<List<Word>> {
        return api.getWordsByWord(word)
            .subscribeOn(Schedulers.io())
            .map { it.toDomainModel() }
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getDetailMeaningByMeaningId(meaningId: String): Single<List<DetailMeaning>> {
        return api.getDetailMeaningById(meaningId)
            .subscribeOn(Schedulers.io())
            .map { it.toDomainModel() }
            .observeOn(AndroidSchedulers.mainThread())
    }
}