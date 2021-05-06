package com.example.androidexam

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.androidexam.databinding.ActivityThirdBinding
import com.example.androidexam.entities.PortFolio
import com.example.androidexam.viewmodel.ThirdViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    private val viewModel = ThirdViewModel()
    lateinit var a: PortFolio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.dbInit(this)

        var sharedPreferences: SharedPreferences = getSharedPreferences("com.example.androidexam.preference", Context.MODE_PRIVATE)

        viewModel.Points.observe(this, {
            binding.thirdPoints.text = "Points: $it"
        })

        if(sharedPreferences.getLong("FIRST_STARTUP_ID", -1L) == -1L) {
            viewModel.atInstall()
            sharedPreferences.edit().putLong("FIRST_STARTUP_ID", 1L).apply()
        }

        binding.toTransactions.setOnClickListener {
            val intent = Intent(this, SeventhActivity::class.java)
            startActivity(intent)
        }
        viewModel.portFolio.observe(this, {
            binding.output.text = it.volume.toString() + " " + it.symbol
            Picasso.get().load("https://static.coincap.io/assets/icons/${it.symbol.toLowerCase()}@2x.png").into(binding.thirdImage)

        })
    }

}