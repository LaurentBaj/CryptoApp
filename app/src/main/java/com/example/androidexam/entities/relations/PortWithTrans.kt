package com.example.androidexam.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.androidexam.entities.PortFolio
import com.example.androidexam.entities.Transaction

data class PortWithTrans(
    @Embedded val portFolio: PortFolio,
    @Relation(
        parentColumn = "symbol",
        entityColumn = "symbol"
    )
    val transaction: List<Transaction>
)
