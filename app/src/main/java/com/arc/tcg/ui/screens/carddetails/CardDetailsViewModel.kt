package com.arc.tcg.ui.screens.carddetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arc.tcg.data.repository.MainRepository
import com.arc.tcg.ui.navigation.Arg
import com.arc.tcg.utils.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardDetailsViewModel @Inject constructor (
    stateHandle: SavedStateHandle,
    private val repo: MainRepository,
    private val networkHelper: NetworkHelper
): ViewModel() {
    var state by mutableStateOf(
        CardDetailsContract.State(
            card = null,
            isLoading = true,
            isConnected = true,
            itemId = ""
        )
    )

    init {
        val itemId = stateHandle.get<String>(Arg.ID)
        state = state.copy(itemId = itemId!!)
        viewModelScope.launch { getCard(itemId) }
    }

    private fun getCard(id: String?) {
        viewModelScope.launch {
            if(networkHelper.isNetworkConnected()) {
                repo.getCard(id).let {
                    state = if(it.isSuccessful) {
                                state.copy(card = it.body(), isLoading = false, isConnected = true)
                            } else {
                                state.copy(isLoading = false, isConnected = true)
                            }
                }
            } else {
                state = state.copy(isLoading = false, isConnected = false)
            }
        }
    }

    fun reconnection() {
        if(state.card == null) {
            getCard(state.itemId)
        }
    }
}