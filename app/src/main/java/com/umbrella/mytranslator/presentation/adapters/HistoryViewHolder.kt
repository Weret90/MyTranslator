package com.umbrella.mytranslator.presentation.adapters

import androidx.recyclerview.widget.RecyclerView
import com.umbrella.mytranslator.databinding.ItemHistoryBinding

class HistoryViewHolder(private val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(word: String) {
        binding.historyWord.text = word
    }
}