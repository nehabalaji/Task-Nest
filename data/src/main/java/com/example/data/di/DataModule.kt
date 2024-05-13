package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.repository.TaskRepositoryImplementation
import com.example.data.sources.local.TaskDao
import com.example.data.sources.local.TaskDatabase
import com.example.domain.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Singleton
    @Provides
    fun provideTaskDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, TaskDatabase::class.java, "task_database").build()

    @Singleton
    @Provides
    fun provideTaskDao(taskDb: TaskDatabase) = taskDb.getTaskDao()

    @Singleton
    @Provides
    fun provideTaskRepository(dao: TaskDao): TaskRepository = TaskRepositoryImplementation(dao)
}