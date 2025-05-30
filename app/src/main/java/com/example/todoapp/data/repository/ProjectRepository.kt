package com.example.todoapp.data.repository

import com.example.todoapp.data.db.dao.ProjectDao
import com.example.todoapp.data.model.Project
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProjectRepository @Inject constructor(private val projectDao: ProjectDao) {
    suspend fun insertProject(project: Project) {
        projectDao.insert(project)
    }
    suspend fun updateProject(project: Project) {
        projectDao.update(project)
    }
    suspend fun deleteProject(project: Project) {
        projectDao.delete(project)
    }
    fun getAllProjects(): Flow<List<Project>> {
        return projectDao.getAllProjects()
    }

}