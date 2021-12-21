package com.umbrella.mytranslator.data.model.network

import com.google.gson.annotations.SerializedName

data class ImageDataModel(
    @SerializedName(KEY_URL)
    val url: String?
) {
    companion object {
        private const val KEY_URL = "url"
    }
}