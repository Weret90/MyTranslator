package com.umbrella.mytranslator.domain.entity

data class Meaning(
    val id: Int,
    val imageUrl: String?,
    val previewUrl: String?,
    val transcription: String?,
    val translation: Translation?,
)
