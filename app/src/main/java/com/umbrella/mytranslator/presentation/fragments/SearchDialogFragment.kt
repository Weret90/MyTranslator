package com.umbrella.mytranslator.presentation.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.umbrella.mytranslator.R
import com.umbrella.mytranslator.databinding.FragmentSearchDialogBinding
import com.umbrella.mytranslator.presentation.viewmodels.SearchDialogViewModel

class SearchDialogFragment : Fragment() {
    private var _binding: FragmentSearchDialogBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SearchDialogViewModel by lazy {
        ViewModelProvider(this)[SearchDialogViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
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

        initViewModelObservers()

        binding.buttonSearch.setOnClickListener {
            val word = binding.fieldForWord.text.toString()
            viewModel.parseWord(word)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.history_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        parentFragmentManager.beginTransaction()
            .replace(R.id.main_container, HistoryFragment.newInstance())
            .addToBackStack(null)
            .commit()
        return super.onOptionsItemSelected(item)
    }

    private fun initViewModelObservers() {
        viewModel.navigateToWordsFragment.observe(viewLifecycleOwner) { word ->
            word?.let {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.main_container, WordsFragment.newInstance(word))
                    .addToBackStack(null)
                    .commit()
                viewModel.clearNavigateToWordsFragmentLiveData()
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
}