package com.umbrella.mytranslator.data.network

import com.umbrella.mytranslator.data.model.network.DetailMeaningDataModel
import com.umbrella.mytranslator.data.model.network.WordDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("words/search")
    suspend fun getWordsByWord(@Query("search") word: String): List<WordDataModel>

    @GET("meanings")
    suspend fun getDetailMeaningById(@Query("ids") meaningId: String): List<DetailMeaningDataModel>
}