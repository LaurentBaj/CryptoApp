package com.example.androidexam.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexam.databinding.ItemCryptoViewBinding
import com.example.androidexam.model.CryptoStats
import com.squareup.picasso.Picasso

class CryptoListAdapter(private var list: List<CryptoStats>) : RecyclerView.Adapter<CryptoListAdapter.CryptoViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CryptoViewHolder {
        return CryptoViewHolder(ItemCryptoViewBinding.inflate(LayoutInflater.from(parent.context)))
    }


    override fun onBindViewHolder(holder: CryptoListAdapter.CryptoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size


    class CryptoViewHolder(private val binding: ItemCryptoViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(stats: CryptoStats) {
            binding.cryptoName.text = stats.name
            binding.changePercentage.text = stats.changePercent24hr+"%"
            binding.cryptoSymbol.text = stats.symbol
            binding.price.text = stats.price+"$"
            Picasso.get().load("https://static.coincap.io/assets/icons/${stats.symbol.toLowerCase()}@2x.png").into(binding.imageViewFlag)
        }
    }

    fun update(newList: List<CryptoStats>) {
        list = newList
        notifyDataSetChanged()
    }
}