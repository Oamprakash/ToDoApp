package com.example.todoapp.ui.projects

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.todoapp.data.db.TodoAppDatabase
import com.example.todoapp.data.db.dao.ProjectDao
import com.example.todoapp.data.model.Project
import com.example.todoapp.data.repository.ProjectRepository
import com.example.todoapp.ui.theme.ToDoAppTheme
import com.example.todoapp.viewmodel.ProjectsViewViewModel
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext


@Composable
fun AddProjectsViewScreen(navController: NavController){

    var projectName by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Title("Add Project")
        AddProjectTextfield(
            label = "Project Name",
            initialText = projectName,
            onTextChanged = { newName ->
                projectName = newName
            }
        )
        Spacer(modifier = Modifier.weight(1f))
        AddProjectButton(
            "Save", projectName,
            onSaveClicked = { navController.popBackStack() }
        )
    }

}

@Composable
fun AddProjectTextfield(
    initialText: String = "", // Renamed for clarity, or provide a way to hoist state
    label: String,
    modifier: Modifier = Modifier,
    onTextChanged: (String) -> Unit // Callback to notify parent of text changes
) {
    // State to hold the current text in the TextField
    var textState by remember { mutableStateOf(initialText) }

    TextField(
        value = textState, // Current text to display
        onValueChange = { newText ->
            textState = newText // Update the internal state
            onTextChanged(newText) // Notify the caller about the change
        },
        label = { Text(label) }, // How to correctly set a label
        modifier = modifier
    )
}

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun AddProjectButton(buttonText: String, projectName: String, onSaveClicked: (Any) -> Unit, modifier: Modifier = Modifier){
    val context = LocalContext.current
    //val db = TodoAppDatabase.getDatabase(context)
    //val projectDao: ProjectDao = db.projectDao()
    //val projectRepository: ProjectRepository = ProjectRepository(projectDao)
    //val projectsViewViewModel: ProjectsViewViewModel = ProjectsViewViewModel(projectRepository)

    val projectsViewViewModel: ProjectsViewViewModel = viewModel()
    Button(onClick = {
        projectsViewViewModel.addProject(Project( projectName, "Test"))
        Toast.makeText(context, "Project Added", Toast.LENGTH_SHORT).show()
               onSaveClicked("Project Added")
                     },
        modifier = modifier
        .padding(vertical = 2.dp)
        .fillMaxWidth()) {
        Text(text = buttonText,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold)
    }
}



