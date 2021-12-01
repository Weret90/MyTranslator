package com.umbrella.mytranslator.data.mapper

import com.umbrella.mytranslator.data.model.*
import com.umbrella.mytranslator.domain.entity.*

fun WordDataModel.toDomainModel() = Word(
    this.meanings.toDomainModel(),
    this.text
)

fun List<WordDataModel>.toDomainModel() = this.map {
    it.toDomainModel()
}

fun DetailMeaningDataModel.toDomainModel() = DetailMeaning(
    this.definition?.toDomainModel(),
    this.mnemonics,
    this.text,
    this.transcription,
    this.translation?.toDomainModel(),
    this.images?.map { it.toDomainModel() }
)

@JvmName("toDomainModelDetailMeaningDataModel")
fun List<DetailMeaningDataModel>.toDomainModel() = this.map {
    it.toDomainModel()
}

private fun DefinitionDataModel.toDomainModel() = Definition(
    this.text
)

private fun ImageDataModel.toDomainModel() = Image(
    this.url
)

private fun MeaningDataModel.toDomainModel() = Meaning(
    this.id,
    this.imageUrl,
    this.previewUrl,
    this.transcription,
    this.translation?.toDomainModel()
)

private fun TranslationDataModel.toDomainModel() = Translation(
    this.text
)

@JvmName("toDomainModelMeaningDataModel")
private fun List<MeaningDataModel>.toDomainModel() = this.map {
    it.toDomainModel()
}