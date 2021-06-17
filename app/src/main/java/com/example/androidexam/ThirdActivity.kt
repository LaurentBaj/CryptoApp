package com.example.androidexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidexam.databinding.ActivityThirdBinding
import com.example.androidexam.viewmodel.ThirdViewModel
import com.squareup.picasso.Picasso


class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    private val viewModel = ThirdViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // currency is not a list yet
        viewModel.dbInit(this)
        viewModel.currency.observe(this, {
            binding.output.text = it.volume.toString() + " " + it.symbol
            binding.thirdPoints.text = it.worth.toString()
            Picasso.get().load("https://static.coincap.io/assets/icons/${it.symbol.toLowerCase()}@2x.png").into(binding.thirdImage)
        })

        // -> Transactions
        binding.toTransactions.setOnClickListener {
            val intent = Intent(this, SeventhActivity::class.java)
            startActivity(intent)
        }
    }
}