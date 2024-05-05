package com.example.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.constants.PriorityLevel

@Entity(tableName = "task_table")
data class DTask(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: PriorityLevel = PriorityLevel.LOW
)
