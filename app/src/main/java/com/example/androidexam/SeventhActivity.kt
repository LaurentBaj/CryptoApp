package com.example.androidexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidexam.databinding.ActivitySeventhBinding

class SeventhActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySeventhBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeventhBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}