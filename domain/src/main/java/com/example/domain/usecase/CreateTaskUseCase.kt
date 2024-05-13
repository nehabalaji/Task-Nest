package com.example.domain.usecase

import com.example.domain.models.Task
import com.example.domain.repository.TaskRepository

class CreateTaskUseCase(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(task: Task) = repository.createTask(task)
}