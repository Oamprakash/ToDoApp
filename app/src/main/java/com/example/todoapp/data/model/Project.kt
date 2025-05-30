package com.example.todoapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "projects")
data class Project(
//    @PrimaryKey val projectId: Int,
    @PrimaryKey @ColumnInfo(name = "project_name") val projectName: String,
    @ColumnInfo(name = "project_description") val projectDescription: String
)

/*data class Project(
    val id: Int,
    val name: String,
    val description: String,
    val task: Task?
)*/
