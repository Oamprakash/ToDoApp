package com.example.todoapp.ui.tasks

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todoapp.ui.theme.ToDoAppTheme

@Composable
fun TaskListViewScreen(navController: NavController, modifier: Modifier = Modifier){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Title("Tasks")
        LazyTaskList()
        Spacer(modifier = Modifier.weight(1f))
        AddTaskButton("Add Task", navController)
    }
}

@Composable
fun LazyTaskList(modifier: Modifier = Modifier){
    LazyColumn {
        items(5) { index ->
            Row(modifier = Modifier.padding(vertical = 2.dp)) {
                Checkbox(
                    modifier = Modifier.align(Alignment.Top),
                    checked = false,
                    onCheckedChange = {})
                Text(
                    text = "Item: $index",
//                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
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
fun AddTaskButton(buttonText: String, navController: NavController, modifier: Modifier = Modifier){
    Button(onClick = { navController.navigate("addTask") }, modifier = modifier
        .padding(vertical = 2.dp)
        .fillMaxWidth()) {
        Text(text = buttonText,
//            style = MaterialTheme.typography.bodyMedium,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)
    }
}

