package com.example.data.repository

import com.example.data.mappers.toDTask
import com.example.data.mappers.toTask
import com.example.data.sources.local.TaskDao
import com.example.domain.models.Task
import com.example.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TaskRepositoryImplementation @Inject constructor(
    private val taskDao: TaskDao
) : TaskRepository{
    override suspend fun createTask(task: Task): Boolean {
        return try {
            taskDao.createTask(task.toDTask())
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun readTasks(): Flow<List<Task>> {
        return taskDao.readTasks().map { dTaskList ->
            dTaskList.map {
                it.toTask()
            }
        }
    }

    override suspend fun updateTask(task: Task): Boolean {
        return try {
            taskDao.updateTask(task.toDTask())
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun deleteTask(id: Int): Boolean {
        return try {
            taskDao.deleteTask(id)
            true
        } catch (e: Exception) {
            false
        }
    }
}