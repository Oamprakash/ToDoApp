package com.example.todoapp.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.todoapp.data.model.Project
import kotlinx.coroutines.flow.Flow

@Dao
interface ProjectDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(project: Project): Long
    @Update
    suspend fun update(project: Project): Int
    @Delete
    suspend fun delete(project: Project): Int
    @Query("SELECT * FROM projects")
    fun getAllProjects(): Flow<List<Project>>
}