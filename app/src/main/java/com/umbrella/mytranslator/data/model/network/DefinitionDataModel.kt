package com.umbrella.mytranslator.data.model.network

import com.google.gson.annotations.SerializedName

data class DefinitionDataModel(
    @SerializedName(KEY_TEXT)
    val text: String?,
) {
    companion object {
        private const val KEY_TEXT = "text"
    }
}