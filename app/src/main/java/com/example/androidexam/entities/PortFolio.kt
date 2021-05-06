package com.example.androidexam.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PortFolio (
        @PrimaryKey(autoGenerate = false)
    val symbol: String,

        val volume: Double,
        var worth: Double
    )