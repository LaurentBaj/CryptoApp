package com.example.androidexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidexam.databinding.ActivityFifthBinding
import com.example.androidexam.model.IntentData
import com.example.androidexam.viewmodel.FifthViewModel
import com.squareup.picasso.Picasso

class FifthActivity: AppCompatActivity() {
    private lateinit var binding: ActivityFifthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transactionType = intent.getStringExtra("type") // Decide Button: BUY || SELL
        val intentPassed = intent.getStringArrayListExtra("data") // Get currency information
        val data = IntentData(intentPassed!![0], intentPassed[1], intentPassed[2])

        /* ** Crypto Values were supposed to change dynamically based upon USD input

            viewModel.usd.observe(this, {
                it.equals(binding.editTextBuy)
            })

            viewModel.crypto.observe(this, {
                it.equals(binding.editTextBuy)
            })

            binding.btnBuy.setOnClickListener {
                viewModel.change(data.priceUsd!!.toDouble())
            }*/


        // UI
        binding.fifthHeaderName.text = data.name
        binding.fifthHeaderPrice.text = data.priceUsd
        binding.fifthLabelCrypto.text = data.symbol!!.toUpperCase()
        binding.btnBuy.text = transactionType // Button
        Picasso.get() // Image
                .load("https://static.coincap.io/assets/icons/${data.symbol}@2x.png")
                .into(binding.fifthImage)
    }
}