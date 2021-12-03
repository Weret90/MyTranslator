package com.umbrella.mytranslator.data.model

import com.google.gson.annotations.SerializedName

data class DetailMeaningDataModel(
    @SerializedName(KEY_DEFINITION)
    val definition: DefinitionDataModel?,
    @SerializedName(KEY_ID)
    val id: String,
    @SerializedName(KEY_IMAGES)
    val images: List<ImageDataModel>?,
    @SerializedName(KEY_MNEMONICS)
    val mnemonics: String?,
    @SerializedName(KEY_TEXT)
    val text: String?,
    @SerializedName(KEY_TRANSCRIPTION)
    val transcription: String?,
    @SerializedName(KEY_TRANSLATION)
    val translation: TranslationDataModel?,
) {
    companion object {
        private const val KEY_DEFINITION = "definition"
        private const val KEY_ID = "id"
        private const val KEY_IMAGES = "images"
        private const val KEY_MNEMONICS = "mnemonics"
        private const val KEY_TEXT = "text"
        private const val KEY_TRANSCRIPTION = "transcription"
        private const val KEY_TRANSLATION = "translation"
    }
}

