package com.akshawty.rizzcard.ui

import androidx.compose.ui.graphics.ImageBitmap

data class RizzCard(
    var name: String = "",
    var desc: String = "",
    var img: ImageBitmap, // change to a default image resource id
    var url: String = ""
)
