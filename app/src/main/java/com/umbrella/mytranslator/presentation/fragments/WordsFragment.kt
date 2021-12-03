package com.umbrella.mytranslator.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.umbrella.mytranslator.R
import com.umbrella.mytranslator.data.network.RetrofitInstance
import com.umbrella.mytranslator.data.repository.WordsRepositoryImpl
import com.umbrella.mytranslator.databinding.FragmentWordsBinding
import com.umbrella.mytranslator.domain.entity.Word
import com.umbrella.mytranslator.domain.usecase.GetWordsListUseCase
import com.umbrella.mytranslator.presentation.adapters.WordsAdapter
import com.umbrella.mytranslator.presentation.presenter.WordsFragmentPresenter

class WordsFragment : Fragment(), WordsScreen {
    private var _binding: FragmentWordsBinding? = null
    private val binding get() = _binding!!
    private val presenter: WordsFragmentPresenter by lazy {
        WordsFragmentPresenter(GetWordsListUseCase(WordsRepositoryImpl(RetrofitInstance.api)))
    }
    private val adapter: WordsAdapter by lazy {
        WordsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentWordsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachScreen(this)

        binding.recyclerView.adapter = adapter

        adapter.onShopItemClickListener = {
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.main_container,
                    WordFullMeaningFragment.newInstance(it.meanings[0].id.toString())
                )
                .addToBackStack(null)
                .commit()
        }

        val word = arguments?.getString(KEY_SEARCHING_WORD, "") ?: ""
        presenter.getWordsList(word)
    }

    override fun showWordsList(words: List<Word>) {
        adapter.setData(words)
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

    override fun onStart() {
        super.onStart()
        presenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachScreen(this)
    }

    companion object {
        private const val KEY_SEARCHING_WORD = "word"

        fun newInstance(word: String): WordsFragment {
            return WordsFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_SEARCHING_WORD, word)
                }
            }
        }
    }
}