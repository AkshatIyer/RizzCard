package com.akshawty.rizzcard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
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
                Image(painter = painterResource(id = R.drawable.shawty),
                    contentDescription = null,
                    alignment = Alignment.Center
                    )
                // Name
                Row(
                    horizontalArrangement = Arrangement.Start
                ) {
                    TextField(
                        value = model.name,
                        onValueChange = {model.updateName(it)},
                        label = {
                            Text("Name")
                        },
                        leadingIcon = {
                            Icon(painter = painterResource(R.drawable.outline_label_24),
                                contentDescription = "Name")
                        }
                    )
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