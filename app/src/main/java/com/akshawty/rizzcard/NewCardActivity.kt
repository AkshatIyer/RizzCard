package com.akshawty.rizzcard

import android.graphics.Bitmap
import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.qrcode.QRCodeWriter

class NewCardActivity {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun NewCardScreen(modifier: Modifier = Modifier, model: UIModel = viewModel()) {

        Scaffold(
            topBar = {
                Row(horizontalArrangement = Arrangement.Start) {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back Button")
                    }
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(Icons.Filled.Done, contentDescription = "Done")
                    }
                }
            }
        ) { contentPadding ->
            Column(modifier = Modifier.padding(contentPadding)) {
                Image(
                    painter = BitmapPainter(getQrCodeBitmap(model.url.ifBlank { "default" }).asImageBitmap()),
                    contentDescription = "QR Code",
                    contentScale = ContentScale.FillBounds,
                    alignment = Alignment.Center,
                    modifier = Modifier.size(135.dp)
                )
                // Name

                TextField(
                    value = model.name,
                    onValueChange = { model.updateName(it) },
                    label = {
                        Text("Name")
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.outline_label_24),
                            contentDescription = "Name"
                        )
                    }
                )

                // URL
                TextField(
                    value = model.url,
                    onValueChange = { model.updateUrl(it) },
                    label = {
                        Text("URL")
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.outline_link_24),
                            contentDescription = "URL"
                        )
                    }
                )

                // Description
                TextField(
                    value = model.desc,
                    onValueChange = { model.updateDesc(it) },
                    label = {
                        Text("Description (Optional)")
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.outline_description_24),
                            contentDescription = "Description"
                        )
                    }
                )

            }


        }
    }

    fun getQrCodeBitmap(url: String): Bitmap {
        val size = 512 //pixels
        val hints = hashMapOf<EncodeHintType, Int>().also {
            it[EncodeHintType.MARGIN] = 1
        } // Make the QR code buffer border narrower
        val bits = QRCodeWriter().encode(url, BarcodeFormat.QR_CODE, size, size)
        return Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565).also {
            for (x in 0 until size) {
                for (y in 0 until size) {
                    it.setPixel(x, y, if (bits[x, y]) Color.BLACK else Color.WHITE)
                }
            }
        }
    }

    @Preview
    @Composable
    fun NewCardPreview() {

        NewCardScreen()
    }

}