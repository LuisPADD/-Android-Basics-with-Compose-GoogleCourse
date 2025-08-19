package com.example.taskmanagercomposebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.taskmanagercomposebasics.ui.theme.TaskManagerComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerComposeBasicsTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    TaskManagerComposeBasicsTheme {
                        TaskImage(
                            text1 = stringResource(R.string.Completition),
                            text2 = stringResource(R.string.Compliment))
                    }
                }
            }
        }
    }
}

@Composable
fun TaskText(t1: String, t2: String, modifier: Modifier = Modifier){
    Text(
        text=t1,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(
                top = 24.dp,
                bottom = 8.dp)


    )
    Text(
        text= t2,
        fontSize = 16.sp,
        textAlign = TextAlign.Center,
    )

}


@Composable
fun TaskImage(text1: String, text2: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.ic_task_completed)

    Column (
       horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ){
        Image(
            painter = image,
            contentDescription = null,
        )
        TaskText(
            t1 = text1,
            t2 = text2,
        )
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerComposeBasicsTheme {
        TaskImage(
            text1 = stringResource(R.string.Completition),
            text2 = stringResource(R.string.Compliment))
    }
}