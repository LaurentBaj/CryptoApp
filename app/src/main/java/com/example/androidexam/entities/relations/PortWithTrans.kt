package com.example.androidexam.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.androidexam.entities.Currency
import com.example.androidexam.entities.Transaction

data class PortWithTrans(
    @Embedded val currency: Currency,
    @Relation(
        parentColumn = "symbol",
        entityColumn = "symbol"
    )
    val transaction: List<Transaction>
)
