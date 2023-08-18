package com.akshawty.rizzcard.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.akshawty.rizzcard.R
import com.akshawty.rizzcard.UIModel
import com.akshawty.rizzcard.ui.theme.RizzCardTheme


    @OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
    @Composable
    fun RizzAppScreen(
        modifier: Modifier = Modifier,
        model: UIModel = viewModel(),
        onFloatingClickAction : () -> Unit
    ) {
        val state = rememberLazyListState()

        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text("RizzCard")
                })
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = onFloatingClickAction,

                ) {
                    Icon(Icons.Outlined.Add, contentDescription = "Add a Card")
                }
            }
        ) { contentPadding ->
            LazyRow(modifier = Modifier.padding(contentPadding),
                flingBehavior = rememberSnapFlingBehavior(lazyListState = state)
            ) {
                items(model.cards) {
                    androidx.compose.material3.Card {
                        Image(
                            painter = BitmapPainter(model.img),
                            contentDescription = null
                        )
                        Text(
                            text = model.name + model.desc
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun Card(name: String, desc: String = "", modifier: Modifier = Modifier, image: Painter) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(393.dp, 822.dp)
        ) {
            androidx.compose.material3.Card(
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
            Card(
                name = "Instagram",
                modifier = Modifier.size(width = 300.dp, height = 400.dp),
                image = painterResource(R.drawable.shawty)
            )
        }
    }
