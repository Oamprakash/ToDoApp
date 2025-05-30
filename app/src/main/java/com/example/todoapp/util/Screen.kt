package com.example.todoapp.util

sealed class Screen(val route: String) {
    data object ProjectList : Screen("projectList")
    data object AddProject : Screen("addProject")
    data object TaskList : Screen("taskList")
    data object AddTask : Screen("addTask")
}
