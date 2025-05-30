package com.example.todoapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapp.data.db.dao.ProjectDao
import com.example.todoapp.data.db.dao.TaskDao
import com.example.todoapp.data.model.Project
import com.example.todoapp.data.model.Task

@Database(entities = [Project::class, Task::class], version = 2, exportSchema = false)
abstract class TodoAppDatabase: RoomDatabase() {
    abstract fun projectDao(): ProjectDao
    abstract fun taskDao(): TaskDao
    companion object {
        @Volatile
        private var INSTANCE: TodoAppDatabase? = null
        fun getDatabase(context: Context): TodoAppDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoAppDatabase::class.java,
                    "todo_app_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }

    }
}