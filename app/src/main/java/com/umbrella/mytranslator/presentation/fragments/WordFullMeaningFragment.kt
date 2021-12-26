package com.umbrella.mytranslator.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import com.umbrella.mytranslator.R
import com.umbrella.mytranslator.databinding.FragmentWordFullMeaningBinding
import com.umbrella.mytranslator.domain.entity.DetailMeaning
import com.umbrella.mytranslator.presentation.viewmodels.WordFullMeaningViewModel
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.createScope
import org.koin.core.component.inject
import org.koin.core.scope.Scope

class WordFullMeaningFragment : Fragment(), KoinScopeComponent {
    private var _binding: FragmentWordFullMeaningBinding? = null
    private val binding get() = _binding!!
    override val scope: Scope by lazy {
        createScope(this)
    }
    private val viewModel: WordFullMeaningViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentWordFullMeaningBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModelObservers()

        val meaningId = arguments?.getString(KEY_MEANING_ID, "") ?: ""
        viewModel.getFullMeaning(meaningId)
    }

    private fun initViewModelObservers() {
        viewModel.detailMeaning.observe(viewLifecycleOwner) {
            renderDetailMeaning(it)
        }

        viewModel.loading.observe(viewLifecycleOwner) { shouldShowLoadingBar ->
            if (shouldShowLoadingBar) {
                binding.loadingBar.visibility = View.VISIBLE
            } else {
                binding.loadingBar.visibility = View.GONE
            }
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) { errorMessage ->
            errorMessage?.let {
                showToast(errorMessage)
                viewModel.clearErrorLiveData()
            }
        }
    }

    private fun renderDetailMeaning(detailMeaning: DetailMeaning) {
        with(binding) {
            mainWord.text = detailMeaning.text

            Picasso.get()
                .load("https:" + detailMeaning.images?.get(0)?.url)
                .placeholder(R.drawable.placeholder)
                .into(imageView)

            translation.text = String.format(
                getString(R.string.word_description),
                detailMeaning.translation?.text,
                detailMeaning.transcription
            )

            definition.text = detailMeaning.definition?.text
            mnemonics.text = detailMeaning.mnemonics
        }
    }

    private fun showToast(text: String?) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.close()
    }

    companion object {
        private const val KEY_MEANING_ID = "meaningId"

        fun newInstance(meaningId: String): WordFullMeaningFragment {
            return WordFullMeaningFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_MEANING_ID, meaningId)
                }
            }
        }
    }
}