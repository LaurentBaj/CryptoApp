package com.example.androidexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidexam.databinding.ActivityFifthBinding
import com.example.androidexam.model.IntentData
import com.example.androidexam.viewmodel.TransactionViewModel
import com.squareup.picasso.Picasso

class FifthActivity: AppCompatActivity() {
    private lateinit var binding: ActivityFifthBinding
    private var viewModel = TransactionViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transactionType = intent.getStringExtra("type") // Decide Button: BUY || SELL
        val intentPassed = intent.getStringArrayListExtra("data") // Get currency information
        val data = IntentData(intentPassed!![0], intentPassed[1], intentPassed[2]) // name, priceUsd, symbol


        // Show currency-worth based upon usd-input
        binding.convert.setOnClickListener {
            val input = binding.editTextBuy.text.toString().toDouble()
            val value = data.priceUsd!!.split("$")[0].toDouble()
            binding.textCrypto.text = String.format("%.5f", (input/value))
            viewModel.usdChange(input)
            viewModel.convert(input, value)
        }


        // UI
        binding.fifthHeaderName.text = data.name
        binding.fifthHeaderPrice.text = data.priceUsd
        binding.fifthLabelCrypto.text = data.symbol!!.toUpperCase()
        binding.btnTransaction.text = transactionType // Button
        Picasso.get() // Image
                .load("https://static.coincap.io/assets/icons/${data.symbol}@2x.png")
                .into(binding.fifthImage)
    }
}