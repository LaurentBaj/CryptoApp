package com.example.androidexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidexam.databinding.ActivityFifthBinding
import com.example.androidexam.model.IntentData
import com.squareup.picasso.Picasso

class FifthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFifthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentPassed = intent.getStringArrayListExtra("data")
        val data = IntentData(intentPassed!![0], intentPassed[1], intentPassed[2])

        // UI
        binding.fifthHeaderName.text = data.name
        binding.fifthHeaderPrice.text = data.priceUsd
        binding.fifthLabelCrypto.text = data.symbol!!.toUpperCase()
        Picasso.get()
                .load("https://static.coincap.io/assets/icons/${data.symbol}@2x.png")
                .into(binding.fifthImage)
    }
}