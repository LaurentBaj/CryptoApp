package com.example.androidexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidexam.databinding.ActivityFourthBinding
import com.example.androidexam.model.IntentData
import com.squareup.picasso.Picasso
import java.util.ArrayList

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Data Passed by intent
        val intentPassed = intent.getStringArrayListExtra("data")
        val data = IntentData(intentPassed!![0], intentPassed[1], intentPassed[2])

        // UI
        binding.fourthCryptoName.text = data.name
        binding.cryptoPrice.text = data.priceUsd
        Picasso.get()
                .load("https://static.coincap.io/assets/icons/${data.symbol}@2x.png")
                .into(binding.fourthImg)

        binding.userInfo.text = "You have 0 BTC \n 0 x ${data.priceUsd} \n 0 USD"

        // Buttons to fifth and sixth act
        binding.btnBuy.setOnClickListener {
           sendIntent(Intent(this, FifthActivity::class.java), intentPassed)
        }

        binding.btnSell.setOnClickListener {
            sendIntent(Intent(this, SixthActivity::class.java), intentPassed)
        }
    }

    private fun sendIntent(intent: Intent, intentPassed: ArrayList<String>) {
        intent.putExtra("data", intentPassed)
        startActivity(intent)
    }
}

