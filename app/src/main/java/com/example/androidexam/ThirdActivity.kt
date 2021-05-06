package com.example.androidexam

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.androidexam.databinding.ActivityThirdBinding
import com.example.androidexam.viewmodel.ThirdViewModel

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    private val viewModel = ThirdViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.dbInit(this)

        var sharedPreferences: SharedPreferences = getSharedPreferences("com.example.androidexam.preference", Context.MODE_PRIVATE)

        viewModel.Points.observe(this, {
            binding.thirdPoints.text = "Points: $it"
        })

        // Check new user
        if(sharedPreferences.getLong("FIRST_STARTUP_ID", -1L) == -1L) {
            viewModel.atInstall()
            sharedPreferences.edit().putLong("FIRST_STARTUP_ID", 1L).apply()
        }


        binding.toTransactions.setOnClickListener {
            val intent = Intent(this, SeventhActivity::class.java)
            startActivity(intent)
        }
    }
}