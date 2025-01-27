package com.example.data.sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.models.DTask
import com.example.data.models.DUser
import com.example.data.util.Converters

@Database(
    entities = [DTask::class, DUser::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class TaskDatabase: RoomDatabase() {
    abstract fun getTaskDao(): TaskDao
}