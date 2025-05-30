package com.example.todoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.model.Project
import com.example.todoapp.data.repository.ProjectRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProjectsViewViewModel @Inject constructor(private val projectRepository: ProjectRepository) : ViewModel() {
    private val _projects = MutableStateFlow<List<Project>>(emptyList())
    val projects: StateFlow<List<Project>> = _projects


    init {
        getAllProjects()
    }

    suspend fun loadProjects() {
        projectRepository.getAllProjects().collect { projects ->
            _projects.value = projects
            println("Projects Loaded ${_projects.value.size}")
        }
    }

    fun addProject(project: Project) = viewModelScope.launch {
        projectRepository.insertProject(project)
        loadProjects()
    }

    fun getAllProjects(): Job = viewModelScope.launch {
        projectRepository.getAllProjects().collect { projects ->
            _projects.value = projects
            println("Projects Loaded ${_projects.value.size}")
        }
    }

    /*suspend fun addProject(project: Project) {
        projectRepository.insertProject(project)
        loadProjects()
    }*/

    suspend fun updateProject(project: Project) {
        projectRepository.updateProject(project)
        loadProjects()
    }

    suspend fun deleteProject(project: Project) {
        projectRepository.deleteProject(project)
        loadProjects()
    }

    /*fun addProject(project: Project) {
        val currentProjects = _projects.value.toMutableList()
        currentProjects.add(project)
        _projects.value = currentProjects
        println("Project Added ${project.projectName}")

    }*/
}