package com.example.data.sources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.models.DTask
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createTask(dTask: DTask)

    @Query("SELECT * FROM task_table")
    fun readTasks(): Flow<List<DTask>>

    @Update
    suspend fun updateTask(dTask: DTask)

    @Query("DELETE FROM task_table WHERE id=:taskId")
    suspend fun deleteTask(taskId: Int)
}