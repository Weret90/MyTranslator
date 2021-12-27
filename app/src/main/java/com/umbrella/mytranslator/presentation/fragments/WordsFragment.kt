package com.umbrella.mytranslator.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.umbrella.mytranslator.R
import com.umbrella.mytranslator.databinding.FragmentWordsBinding
import com.umbrella.mytranslator.presentation.adapters.WordsAdapter
import com.umbrella.mytranslator.presentation.viewmodels.WordsFragmentViewModel
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.createScope
import org.koin.core.component.inject
import org.koin.core.scope.Scope

class WordsFragment : Fragment(), KoinScopeComponent {
    private var _binding: FragmentWordsBinding? = null
    private val binding get() = _binding!!
    private val adapter: WordsAdapter by lazy {
        WordsAdapter()
    }
    override val scope: Scope by lazy {
        createScope(this)
    }
    private val viewModel: WordsFragmentViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentWordsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        initViewModelObservers()

        val word = arguments?.getString(KEY_SEARCHING_WORD, "") ?: ""
        viewModel.getWordsList(word)
    }

    private fun initViewModelObservers() {
        viewModel.wordsList.observe(viewLifecycleOwner) {
            adapter.setData(it)
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

    private fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        scope.close()
        super.onDestroy()
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