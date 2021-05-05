package com.example.androidexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidexam.databinding.ActivityFourthBinding
import com.squareup.picasso.Picasso
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Data Passed by intent
        val intentPassed = intent.getStringArrayListExtra("data")
        val data = IntentData(intentPassed!![0], intentPassed[1], intentPassed[2])

        // Get passed name, price and image
        binding.fourthCryptoName.text = data.name
        binding.cryptoPrice.text = data.priceUsd
        Picasso.get()
                .load("https://static.coincap.io/assets/icons/${data.symbol}@2x.png")
                .into(binding.fourthImg)

        binding.userInfo.text = "You have 0.5 BTC \n 0.5 x ${data.priceUsd} \n Value 27 000 USD"

        // Buttons to fifth and sixth act
        binding.btnBuy.setOnClickListener {
            val intent = Intent(this, FifthActivity::class.java)
            intent.putExtra("data", intentPassed)
            startActivity(intent)
        }

        binding.btnSell.setOnClickListener {
            val intent = Intent(this, SixthActivity::class.java)
            intent.putExtra("data", intentPassed)
            startActivity(intent)
        }
    }
}