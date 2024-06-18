package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TMApp()
                }
            }
        }
    }
}

@Composable
fun TMApp() {
    TaskManager(
        imagepainter = painterResource(id = R.drawable.ic_task_completed),
        mes1 = stringResource(R.string.Description),
        mes2 = stringResource(R.string.Complement)
    )
}

@Composable
fun TaskManager(imagepainter: Painter, mes1: String, mes2: String, modifier: Modifier = Modifier) {
    Column(modifier =
    modifier.fillMaxSize().fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = imagepainter,
            contentDescription = null
        )
        Text(
            text = mes1,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = mes2,
            fontSize = 16.sp
        )
    }

}

@Preview(showBackground = true,showSystemUi = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        TMApp()
    }
}