package com.umbrella.mytranslator.data.mapper

import com.umbrella.mytranslator.data.model.*
import com.umbrella.mytranslator.domain.entity.*

fun WordDataModel.toDomainModel() = Word(
    meanings.toDomainModel(),
    text
)

fun List<WordDataModel>.toDomainModel() = this.map {
    it.toDomainModel()
}

fun DetailMeaningDataModel.toDomainModel() = DetailMeaning(
    definition?.toDomainModel(),
    mnemonics,
    text,
    transcription,
    translation?.toDomainModel(),
    images?.map { it.toDomainModel() }
)

@JvmName("toDomainModelDetailMeaningDataModel")
fun List<DetailMeaningDataModel>.toDomainModel() = this.map {
    it.toDomainModel()
}

private fun DefinitionDataModel.toDomainModel() = Definition(
    text
)

private fun ImageDataModel.toDomainModel() = Image(
    url
)

private fun MeaningDataModel.toDomainModel() = Meaning(
    id,
    imageUrl,
    previewUrl,
    transcription,
    translation?.toDomainModel()
)

private fun TranslationDataModel.toDomainModel() = Translation(
    text
)

@JvmName("toDomainModelMeaningDataModel")
private fun List<MeaningDataModel>.toDomainModel() = this.map {
    it.toDomainModel()
}