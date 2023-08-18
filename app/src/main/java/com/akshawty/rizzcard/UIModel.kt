package com.akshawty.rizzcard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.ImageBitmap
import androidx.lifecycle.ViewModel
import com.akshawty.rizzcard.ui.RizzCard
import com.akshawty.rizzcard.ui.theme.uiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.updateAndGet

class UIModel : ViewModel() {
    var cards: MutableList<RizzCard> = mutableListOf()
    private val _uiState = MutableStateFlow(uiState())
    val uiState: StateFlow<uiState> = _uiState.asStateFlow()

    var name by mutableStateOf("")
        private set

    var desc by mutableStateOf("")
        private set
    var url by mutableStateOf("")
        private set
    var img by mutableStateOf(ImageBitmap(1, 1))
        private set

    fun addNewCard(

    ) { //change to default image
        _uiState.updateAndGet {
            currentState -> currentState.copy()
        }
        cards.add(
            RizzCard(
                name,
                desc,
                img,
                url
            )
        )
        println()
    }

    fun updateCurrentCard(
        name: String,
        desc: String = "",
        img: ImageBitmap,
        url: String,
        index: Int
    ) {
        cards.get(index).apply {
            this.name = name
            this.desc = desc
            this.img = img
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

    fun updateName(it: String) {
        this.name = it
        _uiState.update { currentState ->
            currentState.copy(
                name = it
            )
        }
    }

    fun updateUrl(it: String) {
        this.url = it
        _uiState.update { currentState ->
            currentState.copy(
                url = it
            )
        }
    }

    fun updateDesc(it: String) {
        this.desc = desc
        _uiState.update { currentState ->
            currentState.copy(
                desc = it
            )
        }
    }

    fun updateImg(it: ImageBitmap) {
        this.img = it
        _uiState.update { currentState ->
            currentState.copy(
                qrCode = it
            )
        }
    }

}