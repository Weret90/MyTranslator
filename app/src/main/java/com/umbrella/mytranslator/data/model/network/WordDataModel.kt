package com.umbrella.mytranslator.data.model.network

import com.google.gson.annotations.SerializedName

data class WordDataModel(
    @SerializedName(KEY_ID)
    val id: Int,
    @SerializedName(KEY_MEANINGS)
    val meanings: List<MeaningDataModel>,
    @SerializedName(KEY_TEXT)
    val text: String,
) {
    companion object {
        private const val KEY_ID = "id"
        private const val KEY_MEANINGS = "meanings"
        private const val KEY_TEXT = "text"
    }
}


