package com.example.androidexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.androidexam.databinding.ActivitySeventhBinding
import com.example.androidexam.entities.PortFolio
import com.example.androidexam.entities.Transaction
import com.example.androidexam.entities.relations.PortWithTrans
import com.example.androidexam.model.Type
import kotlinx.coroutines.launch
import java.util.*

class SeventhActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySeventhBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeventhBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}