package com.umbrella.mytranslator.domain.entity

data class Word(
    val meanings: List<Meaning>,
    val text: String
)