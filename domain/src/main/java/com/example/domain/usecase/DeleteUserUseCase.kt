package com.example.domain.usecase

import com.example.domain.models.User
import com.example.domain.repository.TaskRepository
import java.util.UUID

class DeleteUserUseCase(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(uuid: UUID) = repository.deleteUser(uuid.toString())
}