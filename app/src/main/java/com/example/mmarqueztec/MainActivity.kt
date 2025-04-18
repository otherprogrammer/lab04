package com.example.mmarqueztec

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.mmarqueztec.ui.theme.MmarquezTecTheme
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow

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
@Composable
fun ViewHolaCurso() {
    Column(
        modifier = Modifier
            .fillMaxWith()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to the Course!",
            fontSize = 28.sp,
            fontWeight = FontWeigh.Bold
        )
        Spacer(modifier = Modifier.heigh(16.dp))
        Text(
            text = "Hello, Student!",
            fontSize = 20.xD
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseApp() {
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Rutina Express") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                showDialog = true
            }) {
                Icon(Icons.Default.PlayArrow, contentDescription = "Iniciar")
            }
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(listOf(
                "🏋️‍♂️ Press de pecho",
                "🏃‍♂️ Cardio",
                "🧘‍♀️ Yoga",
                "💪 Bíceps"
            )) { ejercicio ->
                Text(
                    text = ejercicio,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }

        // 💬 Diálogo cuando se presiona el botón
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("¡Rutina iniciada!") },
                text = { Text("¡Vamos con todo! 💪") },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Listo")
                    }
                }
            )
        }
    }
}