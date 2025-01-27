package com.example.domain.usecase

import com.example.domain.repository.TaskRepository

class GetUsersForTaskUseCase(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(id:Int) = repository.getUsersForTask(id)
}