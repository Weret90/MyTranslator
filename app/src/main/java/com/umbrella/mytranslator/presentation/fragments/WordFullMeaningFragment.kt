package com.umbrella.mytranslator.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import com.umbrella.mytranslator.R
import com.umbrella.mytranslator.data.network.RetrofitInstance
import com.umbrella.mytranslator.data.repository.WordsRepositoryImpl
import com.umbrella.mytranslator.databinding.FragmentWordFullMeaningBinding
import com.umbrella.mytranslator.domain.entity.DetailMeaning
import com.umbrella.mytranslator.domain.usecase.GetDetailMeaningUseCase
import com.umbrella.mytranslator.presentation.presenter.WordFullMeaningPresenter

class WordFullMeaningFragment : Fragment(), WordFullMeaningScreen {

    private var _binding: FragmentWordFullMeaningBinding? = null
    private val binding get() = _binding!!

    private val presenter: WordFullMeaningPresenter by lazy {
        WordFullMeaningPresenter(GetDetailMeaningUseCase(WordsRepositoryImpl(RetrofitInstance.api)))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentWordFullMeaningBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachScreen(this)

        val meaningId = arguments?.getString(KEY_MEANING_ID, "") ?: ""

        presenter.getFullMeaning(meaningId)
    }

    override fun onStart() {
        super.onStart()
        presenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachScreen(this)
    }

    override fun showFullMeaning(fullMeaning: DetailMeaning) {
        with(binding) {

            mainWord.text = fullMeaning.text

            Picasso.get()
                .load("https:" + fullMeaning.images?.get(0)?.url)
                .placeholder(R.drawable.placeholder)
                .into(imageView)

            translation.text = String.format(
                getString(R.string.word_description),
                fullMeaning.translation?.text,
                fullMeaning.transcription
            )

            definition.text = fullMeaning.definition?.text
            mnemonics.text = fullMeaning.mnemonics
        }
    }

    override fun showErrorMessage(errorMessage: String?) {
        showToast(errorMessage)
    }

    override fun showLoadingBar() {
        binding.loadingBar.visibility = View.VISIBLE
    }

    override fun hideLoadingBar() {
        binding.loadingBar.visibility = View.GONE
    }

    private fun showToast(text: String?) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
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