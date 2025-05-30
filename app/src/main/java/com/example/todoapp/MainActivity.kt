package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.ui.projects.AddProjectsViewScreen
import com.example.todoapp.ui.projects.LazyProjectList
import com.example.todoapp.ui.projects.ProjectButton
import com.example.todoapp.ui.projects.ProjectListViewScreen
import com.example.todoapp.ui.projects.Title
import com.example.todoapp.ui.tasks.AddTasksViewScreen
import com.example.todoapp.ui.tasks.TaskListViewScreen
import com.example.todoapp.ui.theme.ToDoAppTheme
import com.example.todoapp.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoAppTheme {
//                ProjectListView()
                TodoApp()
            }
        }
    }
}

@Composable
fun TodoApp() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "projectList") {
        composable(Screen.ProjectList.route) { ProjectListViewScreen(navController) }
        composable(Screen.AddProject.route) { AddProjectsViewScreen(navController) }
        composable(Screen.TaskList.route) { TaskListViewScreen(navController) }
        composable(Screen.AddTask.route) { AddTasksViewScreen(navController) }
    }
}



