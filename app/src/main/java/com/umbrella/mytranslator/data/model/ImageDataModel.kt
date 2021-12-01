package com.umbrella.mytranslator.data.model

import com.google.gson.annotations.SerializedName

data class ImageDataModel(
    @SerializedName("url")
    val url: String?
)