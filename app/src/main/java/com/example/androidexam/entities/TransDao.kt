package com.example.androidexam.entities

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidexam.entities.relations.PortWithTrans

@Dao
interface TransDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPortfolio(currency: Currency)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: Transaction)

    @androidx.room.Transaction
    @Query("SELECT * FROM Currency WHERE symbol = :symbol")
    suspend fun getPortFolioWithTransactions(symbol: String): List<PortWithTrans>

    @androidx.room.Transaction
    @Query("SELECT SUM(worth) FROM Currency")
    suspend fun getWorth() : Double

    @androidx.room.Transaction
    @Query("SELECT * FROM Currency")
    suspend fun fetchData() : Currency
}