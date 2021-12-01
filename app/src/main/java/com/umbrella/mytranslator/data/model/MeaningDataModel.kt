package com.umbrella.mytranslator.data.model

import com.google.gson.annotations.SerializedName

data class MeaningDataModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageUrl")
    val imageUrl: String?,
    @SerializedName("previewUrl")
    val previewUrl: String?,
    @SerializedName("transcription")
    val transcription: String?,
    @SerializedName("translation")
    val translation: TranslationDataModel?
)