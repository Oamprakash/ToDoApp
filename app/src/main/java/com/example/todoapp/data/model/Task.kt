package com.example.todoapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey val taskId: Int,
    val taskName: String,
    val taskDescription: String,
    val taskStatus: Boolean,
    val taskPriority: String,
    val projectId: Int

)

/*data class Task(
    val id: Int,
    val name: String,
    val description: String,
    val status: Boolean,
    val priority: String,
    val projectId: Int
)*/
