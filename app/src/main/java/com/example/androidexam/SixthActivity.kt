package com.example.androidexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidexam.databinding.ActivityFifthBinding
import com.example.androidexam.databinding.ActivitySixthBinding
import com.squareup.picasso.Picasso

class SixthActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySixthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySixthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentPassed = intent.getStringArrayListExtra("data")
        val data = IntentData(intentPassed!![0], intentPassed[1], intentPassed[2])
        Picasso.get()
                .load("https://static.coincap.io/assets/icons/${data.symbol}@2x.png")
                .into(binding.sixthImage)

        binding.sixthHeaderName.text = data.name
        binding.sixthHeaderPrice.text = data.priceUsd
    }
}