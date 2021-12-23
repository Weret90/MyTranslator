package com.umbrella.mytranslator.domain.usecase

import com.umbrella.mytranslator.domain.entity.DetailMeaning
import com.umbrella.mytranslator.domain.repository.WordsRepository

class GetDetailMeaningUseCase(private val repository: WordsRepository) {

    suspend operator fun invoke(meaningId: String): List<DetailMeaning> {
        return repository.getDetailMeaningByMeaningId(meaningId)
    }
}