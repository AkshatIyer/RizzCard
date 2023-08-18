package com.akshawty.rizzcard.ui.theme

import androidx.compose.ui.graphics.ImageBitmap
import com.akshawty.rizzcard.R

data class uiState(
    var index: Int = 0,
    var name: String = "",
    var url: String = "",
    var desc: String = "",
    var qrCode: ImageBitmap = ImageBitmap(1, 1)
)