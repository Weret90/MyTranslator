package com.umbrella.mytranslator.presentation.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.umbrella.mytranslator.R
import com.umbrella.mytranslator.databinding.FragmentHistoryBinding
import com.umbrella.mytranslator.presentation.adapters.HistoryAdapter
import com.umbrella.mytranslator.presentation.viewmodels.HistoryViewModel
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.createScope
import org.koin.core.component.inject
import org.koin.core.scope.Scope

class HistoryFragment : Fragment(), KoinScopeComponent {

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!
    override val scope: Scope by lazy {
        createScope(this)
    }
    private val viewModel: HistoryViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.clear_history_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.deleteAllWords()
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = HistoryAdapter()
        binding.historyRecyclerView.adapter = adapter
        viewModel.historyLiveData.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }

        adapter.onShopItemClickListener = {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_container, WordsFragment.newInstance(it.word))
                .addToBackStack(null)
                .commit()
        }
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
        fun newInstance(): HistoryFragment {
            return HistoryFragment()
        }
    }
}