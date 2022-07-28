package com.example.mainactivity.mainpage

import android.content.Context
import androidx.room.Room
import com.example.mainactivity.db.AppDataBase
import com.example.mainactivity.db.Entry
import com.example.mainactivity.utilities.DATABASE_NAME
import kotlin.concurrent.thread

class MainPageModel(context: Context) {
    private val db = Room.databaseBuilder(context, AppDataBase::class.java, DATABASE_NAME).build()
    private val entryDao = db.entryDao()

    fun saveEntryToDb(entry: Entry) {
        thread {
            entryDao.insertAll(entry)
        }
    }

    fun getAllEntries(): List<Entry> {
        return entryDao.getAll().value!!
    }
}