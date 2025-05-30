package com.example.todoapp.ui.tasks

import android.os.Bundle
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todoapp.ui.projects.Title
import com.example.todoapp.ui.theme.ToDoAppTheme


@Composable
fun AddTasksViewScreen(navController: NavController){

    var taskName by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Title("Add Task")
        AddTaskTextfield(
            label = "Task Name",
            initialText = taskName,
            onTextChanged = { newName ->
                taskName = newName
            }
        )
        Spacer(modifier = Modifier.weight(1f))
        SaveTaskButton("Save")
    }

}

@Composable
fun AddTaskTextfield(
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

@Composable
fun SaveTaskButton(buttonText: String, modifier: Modifier = Modifier){
    Button(onClick = {  }, modifier = modifier
        .padding(vertical = 2.dp)
        .fillMaxWidth()) {
        Text(text = buttonText,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold)
    }
}



