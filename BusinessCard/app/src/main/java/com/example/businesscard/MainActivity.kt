package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Screen()
                }
            }
        }
    }
}

@Composable
fun BotTop(title: String, t1: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Column(modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .background(Color(0xFF073042))
                .size(120.dp)
                .padding(bottom = 8.dp)

        )
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 10.dp, top = 20.dp)
        )
        Text(
            text = t1,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF177848),
        )
    }
}

@Composable
fun BotBottom(t2: String, t3: String, t4: String, modifier: Modifier = Modifier) {
    Column( modifier = modifier
        .padding(bottom = 32.dp)){

        Row (modifier = Modifier.padding( 5.dp)){
            Icon(
                imageVector = Icons.Filled.Phone,
                contentDescription = null,
                tint = Color(0xFF006837),
                modifier = Modifier.padding(end = 10.dp)
            )
            Text(
                text = t2,
                color = Color(0xFF177848)
            )
        }


        Row (modifier = Modifier.padding( 5.dp)) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = null,
                tint = Color(0xFF006837),
                modifier = Modifier.padding(end = 10.dp)
            )
            Text(
                text = t3,
                color = Color(0xFF177848)
            )
        }


        Row (modifier = Modifier.padding( 5.dp)){
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = null,
                tint = Color(0xFF006837),
                modifier = Modifier.padding(end = 10.dp)
            )
            Text(
                text = t4,
                color = Color(0xFF177848)
            )
        }
    }
}




@Composable
fun Screen(modifier: Modifier = Modifier) {
    Column (modifier = modifier
        .background(Color(0xFFD2E8D4))) {
        Box(
            modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            BotTop(
                title = stringResource(R.string.name),
                t1 = stringResource(R.string.position),
                modifier = Modifier.align(Alignment.Center)
            )
            BotBottom(
                t2 = stringResource(R.string.phone_number),
                t3 = stringResource(R.string.share_contact),
                t4 = stringResource(R.string.email),
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Screen()
    }
}