package com.umbrella.mytranslator.data.network

import com.umbrella.mytranslator.data.model.DetailMeaningDataModel
import com.umbrella.mytranslator.data.model.WordDataModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("words/search")
    fun getWordsByWord(@Query("search") word: String): Single<List<WordDataModel>>

    @GET("meanings")
    fun getDetailMeaningById(@Query("ids") meaningId: String): Single<List<DetailMeaningDataModel>>
}