import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgallery.R
import com.example.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtGalleryTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ArtApp()
                }
            }
        }
    }
}

@Composable
fun ShowArt(art: Int, modifier: Modifier = Modifier) {
    Surface(
        color = Color.White, // moldura
        shadowElevation = 8.dp,
        modifier = modifier
            .widthIn(max = 400.dp) // largura estilo celular
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = art),
            contentDescription = null,
            contentScale = ContentScale.Fit, // mantém proporção da imagem
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp) // borda interna
        )
    }
}


@Composable
fun ShowTitle(title: String, artist: String, year: String, modifier: Modifier = Modifier) {
    Surface(
        color = Color(0xFFECEBF4),
        modifier = modifier
            .widthIn(max = 400.dp) // mesma largura da moldura
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
            Text(
                text = "$artist ($year)",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }
    }
}



@Composable
fun ButtonNextPrev(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth() // sempre pega a largura inteira
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = onPreviousClick, shape = RoundedCornerShape(50)) {
            Text(text = "Previous")
        }

        Button(onClick = onNextClick, shape = RoundedCornerShape(50)) {
            Text(text = "Next")
        }
    }
}


@Composable
fun ArtApp(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableStateOf(1) }

    val onPrevious = { currentStep = if (currentStep == 1) 3 else currentStep - 1 }
    val onNext = { currentStep = if (currentStep == 3) 1 else currentStep + 1 }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Título + botões no rodapé
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (currentStep) {
                1 -> ShowTitle("The Passage of Hors And Vaal Cars", "Bols' Arr", "2015")
                2 -> ShowTitle("Orgumsa", "Jahlim", "2008")
                3 -> ShowTitle("Ohm' Menn", "Bash Arr", "2001")
            }
            Spacer(modifier = Modifier.height(8.dp))
            ButtonNextPrev(
                onPreviousClick = onPrevious,
                onNextClick = onNext,
                modifier = Modifier.fillMaxWidth()
            )
        }


        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(bottom = 120.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (currentStep) {
                1 -> ShowArt(R.drawable.image1)
                2 -> ShowArt(R.drawable.image2)
                3 -> ShowArt(R.drawable.image3)
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun ArtGalleryLayoutPreview() {
    ArtGalleryTheme {
        ArtApp()
    }
}