package com.umbrella.mytranslator.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.umbrella.mytranslator.R
import com.umbrella.mytranslator.databinding.FragmentSearchDialogBinding
import com.umbrella.mytranslator.presentation.presenter.SearchDialogPresenter

class SearchDialogFragment : Fragment(), SearchDialogScreen {
    private var _binding: FragmentSearchDialogBinding? = null
    private val binding get() = _binding!!
    private val presenter: SearchDialogPresenter by lazy {
        SearchDialogPresenter()
    }

    override fun onStart() {
        super.onStart()
        presenter.attachScreen(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSearchDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSearch.setOnClickListener {
            val word = binding.fieldForWord.text.toString()
            presenter.parseWord(word)
        }
    }

    override fun goToScreenWithWords(word: String) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.main_container, WordsFragment.newInstance(word))
            .addToBackStack(null)
            .commit()
    }

    override fun showErrorMessage(errorMessage: String) {
        showToast(errorMessage)
    }

    private fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        presenter.detachScreen(this)
    }
}