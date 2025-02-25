package com.arc.tcg.ui.screens.cardslist

import com.arc.tcg.data.model.CardBrief

class CardListContract {
    data class State (
        val cards: List<CardBrief> = listOf(),
        val isLoading: Boolean  = false,
        val isConnected: Boolean = false
    )
}