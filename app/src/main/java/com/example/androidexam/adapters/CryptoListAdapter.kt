package com.example.androidexam.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexam.FourthActivity
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
        var current = list[position]
        holder.bind(current)

        // Make each card clickable
        holder.itemView.setOnClickListener {
            var intent = Intent(holder.itemView.context, FourthActivity::class.java)

            intent.putExtra("name", current.name)
            intent.putExtra("priceUsd", current.priceUsd.toString())
            intent.putExtra("symbol", current.symbol)

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = list.size


    class CryptoViewHolder(private val binding: ItemCryptoViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(stats: CryptoStats) {
            binding.cryptoName.text = stats.name
            binding.changePercentage.text = sliceToOutput(stats.changePercent24Hr.toString(), '%')
            binding.cryptoSymbol.text = stats.symbol
            binding.price.text = sliceToOutput(stats.priceUsd.toString(), '$')
            Picasso.get().load("https://static.coincap.io/assets/icons/${stats.symbol.toString().toLowerCase()}@2x.png").into(binding.imageViewCrypto)
        }
    }

    fun update(newList: List<CryptoStats>) {
        list = newList
        notifyDataSetChanged()
    }

}

// Avert too many decimals in output
fun sliceToOutput(input: String, symbol: Char): String {
    val slicedInput = input.split(".")
    return slicedInput[0] + "." + slicedInput[1].slice(0..0) + symbol
}