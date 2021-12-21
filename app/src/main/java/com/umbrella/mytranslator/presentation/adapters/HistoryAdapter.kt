package com.umbrella.mytranslator.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.umbrella.mytranslator.databinding.ItemHistoryBinding
import com.umbrella.mytranslator.domain.entity.SimpleWord

class HistoryAdapter : RecyclerView.Adapter<HistoryViewHolder>() {
    private var words: List<SimpleWord> = listOf()
    var onShopItemClickListener: ((SimpleWord) -> Unit)? = null

    fun setData(words: List<SimpleWord>) {
        this.words = words
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(words[position].word)
        holder.itemView.setOnClickListener {
            onShopItemClickListener?.invoke(words[position])
        }
    }

    override fun getItemCount(): Int {
        return words.size
    }
}