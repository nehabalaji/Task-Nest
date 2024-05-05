package com.example.data.sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.models.DTask

@Database(
    entities = [DTask::class],
    version = 1,
    exportSchema = false
)
abstract class TaskDatabase: RoomDatabase() {
    abstract fun getTaskDao(): TaskDao
}