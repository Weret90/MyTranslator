package com.umbrella.mytranslator.domain.entity

data class DetailMeaning(
    val definition: Definition?,
    val mnemonics: String?,
    val text: String?,
    val transcription: String?,
    val translation: Translation?,
    val images: List<Image>?
)
