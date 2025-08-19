package com.example.practice_composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice_composebasics.ui.theme.PracticeComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeComposeBasicsTheme {
                Surface(modifier = Modifier.fillMaxSize()) {

                }
            }
        }
    }
}


@Composable
fun ComposeText(titulo: String,desc1: String, desc2: String, modifier: Modifier = Modifier){
    Text(
        text = titulo,
        fontSize = 24.sp,

        modifier = Modifier
            .padding(16.dp)
    )
    Text(
        text = desc1,
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
            )
    )
    Text(
        text = desc2,
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .padding(16.dp),
    )
}

@Composable
fun ComposeImage(titulo: String,desc1: String, desc2: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)

    Column (modifier = modifier) {
        Image(
            painter = image,
            contentDescription = null,
        )
        ComposeText(
            titulo = titulo,
            desc1 = desc1,
            desc2 = desc2
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticeComposeBasicsTheme {
        ComposeImage(
            titulo = stringResource(R.string.Titulo),
            desc1 = stringResource(R.string.Descricao1),
            desc2 = stringResource(R.string.Descricao2)
        )

    }
}