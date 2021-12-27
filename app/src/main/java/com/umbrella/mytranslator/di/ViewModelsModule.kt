package com.umbrella.mytranslator.di

import com.umbrella.mytranslator.domain.usecase.DeleteAllWordsInDbUseCase
import com.umbrella.mytranslator.domain.usecase.GetAllWordsFromDbUseCase
import com.umbrella.mytranslator.domain.usecase.GetDetailMeaningUseCase
import com.umbrella.mytranslator.domain.usecase.GetWordsListUseCase
import com.umbrella.mytranslator.presentation.fragments.HistoryFragment
import com.umbrella.mytranslator.presentation.fragments.SearchDialogFragment
import com.umbrella.mytranslator.presentation.fragments.WordFullMeaningFragment
import com.umbrella.mytranslator.presentation.fragments.WordsFragment
import com.umbrella.mytranslator.presentation.viewmodels.HistoryViewModel
import com.umbrella.mytranslator.presentation.viewmodels.SearchDialogViewModel
import com.umbrella.mytranslator.presentation.viewmodels.WordFullMeaningViewModel
import com.umbrella.mytranslator.presentation.viewmodels.WordsFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    scope<WordsFragment> {
        scoped {
            GetWordsListUseCase(repository = get())
        }
        viewModel {
            WordsFragmentViewModel(getWordsListUseCase = get())
        }
    }

    scope<WordFullMeaningFragment> {
        scoped {
            GetDetailMeaningUseCase(repository = get())
        }
        viewModel {
            WordFullMeaningViewModel(getDetailMeaningUseCase = get())
        }
    }

    scope<HistoryFragment> {
        scoped {
            DeleteAllWordsInDbUseCase(repository = get())
        }
        scoped {
            GetAllWordsFromDbUseCase(repository = get())
        }
        viewModel {
            HistoryViewModel(deleteAllWordsInDbUseCase = get(), getAllWordsFromDbUseCase = get())
        }
    }

    scope<SearchDialogFragment> {
        viewModel {
            SearchDialogViewModel()
        }
    }
}