package com.example.androidexam

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidexam.entities.PortFolio
import com.example.androidexam.entities.TransDao
import com.example.androidexam.entities.Transaction
import com.example.androidexam.model.Type
import java.security.AccessControlContext

@Database(
    entities = [
        PortFolio::class,
        Transaction::class
    ],
    version = 1
)

abstract class AppDB : RoomDatabase() {

    abstract val transDao: TransDao

    companion object {
        @Volatile
        private var INSTANCE: AppDB? = null

        fun getInstance(context: Context): AppDB {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDB::class.java,
                    "AppDB"
                ).fallbackToDestructiveMigration().build().also {
                    INSTANCE = it
                }
            }
        }
    }
}