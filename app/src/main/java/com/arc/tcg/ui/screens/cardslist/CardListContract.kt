package com.arc.tcg.ui.screens.cardslist

import com.arc.tcg.data.model.TCGCard

class CardListContract {
    data class State (
        val cards: List<TCGCard> = listOf(),
        val isLoading: Boolean  = false
    )
}