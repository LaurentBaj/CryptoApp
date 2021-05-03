package com.example.androidexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidexam.adapters.CryptoListAdapter
import com.example.androidexam.databinding.ActivitySecondBinding
import com.example.androidexam.datasources.DummySource
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

        listAdapter = CryptoListAdapter(ArrayList<CryptoStats>())

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = listAdapter

        viewModel.liveStats.observe(this, { list ->
            listAdapter.update(list)
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