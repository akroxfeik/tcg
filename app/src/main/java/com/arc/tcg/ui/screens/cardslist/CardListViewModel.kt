package com.arc.tcg.ui.screens.cardslist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arc.tcg.data.repository.MainRepository
import com.arc.tcg.utils.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardListViewModel @Inject constructor (
    private val repo: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {
    var state by mutableStateOf(
        CardListContract.State(
            cards = listOf(),
            isLoading = true
        )
    )

    init {
        viewModelScope.launch { getCards() }
    }

    private fun getCards(name: String? = "") {
        viewModelScope.launch {
            val isConnected = networkHelper.isNetworkConnected()
            val cardList = if(isConnected) repo.getCards(name) else null

            state = state.copy(
                cards = cardList?.body() ?: listOf(),
                isLoading = false
            )
        }
    }

    fun searchCards(name: String?) {
        getCards(name)
    }
}