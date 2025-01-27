package com.example.data.sources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.models.DTask
import com.example.data.models.DUser
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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createUser(dUser: DUser)

    @Query("SELECT * FROM user_table WHERE uuid in (SELECT users FROM task_table where id = :id)")
    fun getUsersForTask(id: Int): Flow<List<DUser>>

    @Update
    suspend fun updateUser(dUser: DUser)

    @Query("DELETE FROM user_table WHERE uuid=:id")
    suspend fun deleteUser(id: String)
}