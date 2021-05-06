package com.example.androidexam.entities

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidexam.entities.relations.PortWithTrans

@Dao
interface TransDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPortfolio(portFolio: PortFolio)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: Transaction)

    @androidx.room.Transaction
    @Query("SELECT * FROM PORTFOLIO WHERE symbol = :symbol")
    suspend fun getPortFolioWithTransactions(symbol: String): List<PortWithTrans>

    @androidx.room.Transaction
    @Query("SELECT SUM(worth) FROM PORTFOLIO")
    suspend fun getWorth() : Double
}