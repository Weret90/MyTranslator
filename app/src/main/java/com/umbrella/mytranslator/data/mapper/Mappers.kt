package com.umbrella.mytranslator.data.mapper

import com.umbrella.mytranslator.data.model.MeaningDataModel
import com.umbrella.mytranslator.data.model.TranslationDataModel
import com.umbrella.mytranslator.data.model.WordDataModel
import com.umbrella.mytranslator.domain.entity.Meaning
import com.umbrella.mytranslator.domain.entity.Translation
import com.umbrella.mytranslator.domain.entity.Word

fun WordDataModel.toDomainModel() = Word(
    this.meanings.toDomainModel(),
    this.text
)

fun List<WordDataModel>.toDomainModel() = this.map {
    it.toDomainModel()
}

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