package com.example.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class DUser (
    @PrimaryKey(autoGenerate = false)
    val uuid: String,
    val name: String,
    val email: String
)
