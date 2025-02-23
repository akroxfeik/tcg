package com.arc.tcg.ui.screens.carddetails

import com.arc.tcg.data.model.TCGCardDetail

class CardDetailsContract {
    data class State (
        val card: TCGCardDetail? = null,
        val isLoading: Boolean  = false
    )
}