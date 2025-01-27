package com.example.domain.usecase

import com.example.domain.models.User
import com.example.domain.repository.TaskRepository

class UpdateUserUseCase(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(user: User) = repository.updateUser(user)
}