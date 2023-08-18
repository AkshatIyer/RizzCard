package com.akshawty.rizzcard

import androidx.lifecycle.ViewModel
import com.akshawty.rizzcard.ui.theme.Card
import com.akshawty.rizzcard.ui.theme.uiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class UIModel: ViewModel() {
    private var cards : MutableList<Card> = mutableListOf()
    private val _uiState = MutableStateFlow(uiState())
    val uiState: StateFlow<uiState> = _uiState.asStateFlow()

    fun addNewCard(name: String, desc: String = "", imageResourceId: Int = 0, url: String) { //change to default image
        cards.add(Card(name, desc, imageResourceId, url))
    }

    fun updateCurrentCard(name: String, desc: String = "", imageResourceId: Int = 0, url: String, index: Int) {
        cards.get(index).apply {
            this.name = name
            this.desc = desc
            this.imageResourceId = imageResourceId
            this.url = url
        }
    }

    fun deleteCurrentCard(index: Int) {
        if (index >= 0) {
            cards.removeAt(index)
        }
    }

    fun getNumCards(): Int {
        return cards.size
    }
}