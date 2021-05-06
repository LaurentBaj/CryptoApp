package com.example.androidexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.androidexam.databinding.ActivitySeventhBinding
import com.example.androidexam.entities.PortFolio
import com.example.androidexam.entities.Transaction
import com.example.androidexam.model.Type
import kotlinx.coroutines.launch
import java.util.*

class SeventhActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySeventhBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeventhBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dao = AppDB.getInstance(this).transDao

        val portFolio = PortFolio("BTC", 0.5, 27000.2)
        val transaction = Transaction(symbol = "BTC", type = "Sold", volume = 0.2, worth = 3000.2, id = 0)

        lifecycleScope.launch {
            dao.insertPortfolio(portFolio)
            dao.insertTransaction(transaction)
            dao.getPortFolioWithTransactions("BTC")
        }
        binding.pointView.text = portFolio.symbol
    }

}