package com.example.androidexam

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidexam.adapters.CryptoListAdapter
import com.example.androidexam.databinding.ActivitySecondBinding
import com.example.androidexam.model.CryptoStats
import com.example.androidexam.viewmodel.SecondViewModel

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private val viewModel = SecondViewModel()

    private lateinit var listAdapter: CryptoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.dbInit(this)

        var sharedPreferences: SharedPreferences = getSharedPreferences("com.example.androidexam.preference", Context.MODE_PRIVATE)

        // Check new user
        if(sharedPreferences.getLong("FIRST_STARTUP_ID", -1L) == -1L) {
            viewModel.atInstall()
            sharedPreferences.edit().putLong("FIRST_STARTUP_ID", 1L).apply()
        }

        listAdapter = CryptoListAdapter(ArrayList<CryptoStats>())

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = listAdapter

        // Observables
        observableData()

        // -> Third Act
        binding.pointView.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }

    private fun observableData() {
        viewModel.Points.observe(this, {
            binding.pointView.text = "Points: $it"
        })

        viewModel.liveStats.observe(this, { newList ->
            listAdapter.update(newList)
        })

        viewModel.isLoading.observe(this, { loading ->
            binding.progressBar.visibility = if (loading) View.VISIBLE else View.INVISIBLE
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.refresh()
    }
}