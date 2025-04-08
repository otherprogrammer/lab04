package com.example.mmarqueztec

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import com.example.mmarqueztec.ui.theme.MmarquezTecTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MmarquezTecTheme {
                ExerciseApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseApp() {
    val exercises = listOf(
        Exercise("Flexiones", "💪"),
        Exercise("Sentadillas", "🏋️"),
        Exercise("Abdominales", "🤸"),
        Exercise("Estiramiento", "🧘")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Rutina Express") }
            )
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(exercises) { exercise ->
                ExerciseCard(exercise)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun ExerciseCard(exercise: Exercise) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = exercise.icon,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = exercise.name,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
