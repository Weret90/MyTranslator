package com.umbrella.mytranslator.domain.usecase

import com.umbrella.mytranslator.domain.entity.DetailMeaning
import com.umbrella.mytranslator.domain.repository.WordsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetDetailMeaningUseCase @Inject constructor(private val repository: WordsRepository) {

    operator fun invoke(meaningId: String): Single<List<DetailMeaning>> {
        return repository.getDetailMeaningByMeaningId(meaningId)
    }
}