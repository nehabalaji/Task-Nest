package com.example.domain.repository

import com.example.domain.models.Task
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun createTask(task: Task): Boolean
    suspend fun readTasks(): Flow<List<Task>>
    suspend fun updateTask(task: Task):Boolean
    suspend fun deleteTask(task: Task):Boolean
}