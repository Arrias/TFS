package com.example.mainactivity.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EntryDao {
    @Query("SELECT * FROM entry")
    fun getAll() : LiveData<List<Entry>>

    @Insert
    fun insertAll(vararg entries : Entry)
}