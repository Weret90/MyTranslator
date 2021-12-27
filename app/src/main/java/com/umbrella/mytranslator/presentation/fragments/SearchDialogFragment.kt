package com.umbrella.mytranslator.presentation.fragments

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.umbrella.mytranslator.R
import com.umbrella.mytranslator.databinding.FragmentSearchDialogBinding
import com.umbrella.mytranslator.presentation.viewmodels.SearchDialogViewModel
import com.umbrella.mytranslator.utils.ViewById
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.createScope
import org.koin.core.component.inject
import org.koin.core.scope.Scope

class SearchDialogFragment : Fragment(), KoinScopeComponent {
    private var _binding: FragmentSearchDialogBinding? = null
    private val binding get() = _binding!!
    override val scope: Scope by lazy {
        createScope(this)
    }
    private val viewModel: SearchDialogViewModel by inject()

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

        val buttonSearch by ViewById<Button>(view, R.id.button_search)

        buttonSearch.setOnClickListener {
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

    override fun onDestroy() {
        scope.close()
        super.onDestroy()
    }
}