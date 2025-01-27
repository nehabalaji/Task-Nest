package com.example.domain.repository

import com.example.domain.models.Task
import com.example.domain.models.User
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun createTask(task: Task): Boolean
    suspend fun readTasks(): Flow<List<Task>>
    suspend fun updateTask(task: Task):Boolean
    suspend fun deleteTask(id: Int):Boolean
    suspend fun createUser(user: User): Boolean
    suspend fun getUsersForTask(taskId: Int): Flow<List<User>>
    suspend fun updateUser(user: User): Boolean
    suspend fun deleteUser(uuid: String): Boolean
}