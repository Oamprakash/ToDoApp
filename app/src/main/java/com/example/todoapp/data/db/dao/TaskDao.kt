package com.example.todoapp.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.data.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert
    suspend fun insert(task: Task): Long
    @Update
    suspend fun update(task: Task): Int
    @Delete
    suspend fun delete(task: Task): Int
    @Query("SELECT * FROM tasks")
    fun getAllTasks(): Flow<List<Task>>
}