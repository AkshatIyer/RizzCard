package com.akshawty.rizzcard.ui.theme

import com.akshawty.rizzcard.R

data class Card(
    var name: String = "",
    var desc: String = "",
    var imageResourceId: Int = R.drawable.shawty, // change to a default image resource id
    var url: String = ""
)
