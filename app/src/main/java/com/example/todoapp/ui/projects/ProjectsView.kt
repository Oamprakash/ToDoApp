package com.example.todoapp.ui.projects

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Layout
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.todoapp.data.db.TodoAppDatabase
import com.example.todoapp.data.db.dao.ProjectDao
import com.example.todoapp.data.model.Project
import com.example.todoapp.data.repository.ProjectRepository
import com.example.todoapp.ui.theme.ToDoAppTheme
import com.example.todoapp.viewmodel.ProjectsViewViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun ProjectListViewScreen(navController: NavController, modifier: Modifier = Modifier){
    val context = LocalContext.current
    /*val db = TodoAppDatabase.getDatabase(context)
    val projectDao: ProjectDao = db.projectDao()
    val projectRepository: ProjectRepository = ProjectRepository(projectDao)
    val projectsViewViewModel: ProjectsViewViewModel = ProjectsViewViewModel(projectRepository)
    val uiState = projectsViewViewModel.projects.collectAsState()
    val projects = uiState.value*/



    val viewModel: ProjectsViewViewModel = viewModel()
    val uiState = viewModel.projects.collectAsState()
    val projects = uiState.value
    println("Projects: ${projects.size}")

    /*LaunchedEffect(Unit) {
        projectsViewViewModel.getAllProjects()
    }*/

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Title("Projects")
        LazyProjectList(navController, projects)
        Spacer(modifier = Modifier.weight(1f))
        ProjectButton("Add Project", navController)
    }
}

@Composable
fun LazyProjectList(navController: NavController, projects: List<Project>, modifier: Modifier = Modifier){
    val context = LocalContext.current
    LazyColumn {
        items(projects.size) { index ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .clickable {
                        // Handle click here
                        navController.navigate("taskList")
                        Toast.makeText(context, "Clicked: ${index}", Toast.LENGTH_SHORT).show()
                    }
                    .height(50.dp), // Add height to the box for visual clarity
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Item: ${projects[index].projectName}",
//                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
fun Title(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier,
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ProjectButton(buttonText: String, navController: NavController, modifier: Modifier = Modifier){
    Button(onClick = { navController.navigate("addProject") },
        modifier = modifier
        .padding(vertical = 2.dp)
        .fillMaxWidth()) {
        Text(text = buttonText,
//            style = MaterialTheme.typography.bodyMedium,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)
    }
}

