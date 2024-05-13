package com.example.domain.di

import com.example.domain.repository.TaskRepository
import com.example.domain.usecase.CreateTaskUseCase
import com.example.domain.usecase.DeleteTaskUseCase
import com.example.domain.usecase.ReadTaskUseCase
import com.example.domain.usecase.UpdateTaskUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideCreateTaskUseCase(taskRepository: TaskRepository) = CreateTaskUseCase(taskRepository)

    @Singleton
    @Provides
    fun provideReadTaskUseCase(taskRepository: TaskRepository) = ReadTaskUseCase(taskRepository)

    @Singleton
    @Provides
    fun provideUpdateTaskUseCase(taskRepository: TaskRepository) = UpdateTaskUseCase(taskRepository)

    @Singleton
    @Provides
    fun provideDeleteTaskUseCase(taskRepository: TaskRepository) = DeleteTaskUseCase(taskRepository)
}