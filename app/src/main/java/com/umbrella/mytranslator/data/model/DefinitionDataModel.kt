package com.umbrella.mytranslator.data.model

import com.google.gson.annotations.SerializedName

data class DefinitionDataModel(
    @SerializedName("text")
    val text: String?
)