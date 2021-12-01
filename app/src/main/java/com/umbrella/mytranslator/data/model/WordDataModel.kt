package com.umbrella.mytranslator.data.model

import com.google.gson.annotations.SerializedName

data class WordDataModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("meanings")
    val meanings: List<MeaningDataModel>,
    @SerializedName("text")
    val text: String
)


