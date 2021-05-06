package com.example.androidexam.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.androidexam.model.Type
import java.util.*

@Entity
data class Transaction(
    @PrimaryKey(autoGenerate = false)
    val symbol: String,

    val type: String,
    val volume: Double,
    val Worth: Double,
)

