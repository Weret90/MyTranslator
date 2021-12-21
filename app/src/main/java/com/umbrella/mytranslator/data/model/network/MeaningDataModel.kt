package com.umbrella.mytranslator.data.model.network

import com.google.gson.annotations.SerializedName

data class MeaningDataModel(
    @SerializedName(KEY_ID)
    val id: Int,
    @SerializedName(KEY_IMAGE_URL)
    val imageUrl: String?,
    @SerializedName(KEY_PREVIEW_URL)
    val previewUrl: String?,
    @SerializedName(KEY_TRANSCRIPTION)
    val transcription: String?,
    @SerializedName(KEY_TRANSLATION)
    val translation: TranslationDataModel?,
) {
    companion object {
        private const val KEY_ID = "id"
        private const val KEY_IMAGE_URL = "imageUrl"
        private const val KEY_PREVIEW_URL = "previewUrl"
        private const val KEY_TRANSCRIPTION = "transcription"
        private const val KEY_TRANSLATION = "translation"
    }
}