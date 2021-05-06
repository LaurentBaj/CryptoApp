package com.example.androidexam.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.androidexam.model.Type
import java.util.*

@Entity
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    val symbol: String,
    val type: String,
    val volume: Double,
    val worth: Double,
)

