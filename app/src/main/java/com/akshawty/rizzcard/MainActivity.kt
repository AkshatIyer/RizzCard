package com.akshawty.rizzcard

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akshawty.rizzcard.ui.theme.RizzCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RizzCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RizzAppScreen()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RizzAppScreen(modifier: Modifier = Modifier) {


    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("RizzCard")
            })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {

            }
        }
    ) { contentPadding ->
        LazyRow(modifier = Modifier.padding(contentPadding)) {

        }

    }
}

@Composable
fun Card(name: String, desc: String = "", modifier: Modifier = Modifier, image: Painter) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.size(393.dp, 822.dp)) {
        Card(
            modifier = modifier,
            elevation = CardDefaults.elevatedCardElevation(),

        ) {
            // QR Code
            Image(
                painter = image,
                contentDescription = "This is your card",
                modifier = Modifier.clip(RoundedCornerShape(12.dp))
            )

            // Name
            Text(
                text = name,
                textAlign = TextAlign.Center,
                modifier = Modifier.size(width = 300.dp, height = 60.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
            )

            // Desc
            Text(
                text = desc
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    RizzCardTheme {
        Card(name = "Instagram",  modifier = Modifier.size(width = 300.dp, height = 400.dp), image = painterResource(R.drawable.shawty))
    }
}