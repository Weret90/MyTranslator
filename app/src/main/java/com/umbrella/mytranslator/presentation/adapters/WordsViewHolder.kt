package com.umbrella.mytranslator.presentation.adapters

import androidx.recyclerview.widget.RecyclerView
import com.umbrella.mytranslator.R
import com.umbrella.mytranslator.databinding.ItemWordBinding
import com.umbrella.mytranslator.domain.entity.Word

class WordsViewHolder(private val binding: ItemWordBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(word: Word) {
        binding.word.text = word.text
        binding.description.text = String.format(
            itemView.context.getString(R.string.word_description),
            word.meanings[0].translation?.text,
            word.meanings[0].transcription
        )
    }
}