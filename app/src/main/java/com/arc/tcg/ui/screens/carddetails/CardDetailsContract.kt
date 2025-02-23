package com.arc.tcg.ui.screens.carddetails

import com.arc.tcg.data.model.CardBriefDetails

class CardDetailsContract {
    data class State (
        val card: CardBriefDetails? = null,
        val isLoading: Boolean  = false
    )
}