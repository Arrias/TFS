package com.example.mainactivity.db

import androidx.room.*
import java.time.LocalDateTime
import java.util.*

@Entity
data class Entry(
    @ColumnInfo(name = "message") val message: String,
    @ColumnInfo(name = "date") val date: Date,
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}

