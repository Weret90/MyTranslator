package com.umbrella.mytranslator.data.model

import com.google.gson.annotations.SerializedName

data class DetailMeaningDataModel(
    @SerializedName("definition")
    val definition: DefinitionDataModel?,
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: List<ImageDataModel>?,
    @SerializedName("mnemonics")
    val mnemonics: String?,
    @SerializedName("text")
    val text: String?,
    @SerializedName("transcription")
    val transcription: String?,
    @SerializedName("translation")
    val translation: TranslationDataModel?,
)

