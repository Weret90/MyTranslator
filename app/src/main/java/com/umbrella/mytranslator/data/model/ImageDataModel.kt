package com.umbrella.mytranslator.data.model

import com.google.gson.annotations.SerializedName

data class ImageDataModel(
    @SerializedName(KEY_URL)
    val url: String?
) {
    companion object {
        private const val KEY_URL = "url"
    }
}