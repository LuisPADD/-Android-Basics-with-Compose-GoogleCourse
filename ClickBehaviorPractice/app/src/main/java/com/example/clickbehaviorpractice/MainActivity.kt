package com.example.clickbehaviorpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clickbehaviorpractice.ui.theme.ClickBehaviorPracticeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClickBehaviorPracticeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Screen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopText(modifier: Modifier = Modifier) {
        Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFF9E44C))
            .padding(bottom = 20.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = "Lemonade",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
    }
}

@Composable
fun MidText(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableStateOf(1) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            when (currentStep){
            1 -> {
                Button(onClick = {
                    currentStep = 2;
                }) {
                    Image(
                        painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = null,
                    )
                }
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = "Tap the lemon tree to select a lemon",
                )
            }
            2 -> {
                var squeezeCount = 0;
                var squeezeNeeded = (2..4).random();

                Button(onClick = {
                    squeezeCount++;
                    if (squeezeCount >= squeezeNeeded) {
                        currentStep = 3;
                    }
                }
                ) {
                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = null,
                    )
                }
                Text(
                    text = "Keep tapping the lemon to squeeze it",
                    modifier = Modifier.padding(16.dp)
                )

            }
            3 ->{
                Button(onClick = {
                    currentStep = 4;
                }) {
                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = null,
                    )
                }
                Text(
                    text = "Tap the lemonade to drink it",
                    modifier = Modifier.padding(16.dp)
                )

            }
            4 -> {
                Button(onClick = {
                    currentStep = 1;
                }) {
                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = null,
                    )
                }
                Text(
                    text = "Tap the empty glass to start again",
                    modifier = Modifier.padding(16.dp)
                )
            }

        }
    }
}

@Composable
fun Screen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        TopText(modifier = Modifier
            .weight(0.10f)
            .fillMaxWidth()
        )
        MidText(modifier = Modifier
            .fillMaxWidth()
            .weight(0.90f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClickBehaviorPracticeTheme {
        Screen()
    }
}
