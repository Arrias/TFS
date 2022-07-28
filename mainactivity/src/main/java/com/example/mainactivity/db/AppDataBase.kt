package com.example.mainactivity.db

import android.content.Context
import androidx.room.*
import com.example.mainactivity.utilities.DATABASE_NAME
import javax.inject.Inject
import javax.inject.Singleton

@Database(entities = [Entry::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun entryDao(): EntryDao

    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDataBase(context).also { instance = it }
            }
        }

        private fun buildDataBase(context: Context): AppDataBase {
            return Room.databaseBuilder(context, AppDataBase::class.java, DATABASE_NAME).build()
        }
    }
}