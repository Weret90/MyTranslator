package com.umbrella.mytranslator.data.model

import com.google.gson.annotations.SerializedName

data class TranslationDataModel(
    @SerializedName("text")
    val text: String?
)