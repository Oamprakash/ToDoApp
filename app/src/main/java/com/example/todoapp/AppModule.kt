package com.example.todoapp

import android.app.Application
import androidx.room.Room
import com.example.todoapp.data.db.TodoAppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideProjectDatabase(application: Application): TodoAppDatabase {
        return Room.databaseBuilder(
            application,
            TodoAppDatabase::class.java,
            "todo_app_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideProjectDao(database: TodoAppDatabase) = database.projectDao()
}