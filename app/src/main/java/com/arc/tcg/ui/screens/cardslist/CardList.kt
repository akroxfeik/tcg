package com.arc.tcg.ui.screens.cardslist

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.arc.tcg.R
import com.arc.tcg.data.model.CardBrief
import com.arc.tcg.ui.screens.CustomImage
import com.arc.tcg.ui.screens.LoadingBar
import com.arc.tcg.utils.InternetConnectivityChanges

@Composable
fun CardList(viewModel: CardListViewModel = hiltViewModel(), onItemClicked: (itemId: String) -> Unit) {
    var text by remember{ mutableStateOf("") }
    Box {
        Column(Modifier.fillMaxSize()) {
            OutlinedTextField(
                value = text,
                onValueChange = {
                    text = it
                    viewModel.searchCards(text)
                },
                label = { Text(stringResource(R.string.search))},
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(Icons.Filled.Search, stringResource(R.string.search_text)) },
                trailingIcon = {
                    if (text.isNotEmpty()) {
                        IconButton(onClick = { text = "" }) {
                            Icon(Icons.Filled.Clear, stringResource(R.string.clear_text))
                        }
                    }
                },
            )
            when {
                viewModel.state.isLoading -> LoadingBar()
                !viewModel.state.isConnected -> Text(
                    text = stringResource(R.string.not_connected),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
                )
            }
            LazyVerticalGrid(
                columns = GridCells.Adaptive(150.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(viewModel.state.cards) { item ->
                    ItemCard(item = item, onItemClicked = onItemClicked)
                }
            }
        }
    }

    /**
     * Force try if connectivity changed.
     * Example:
     * - Open app without internet (http request fails)
     * - Internet connection changes (connects into network)
     * - App retry loading data
     */
    InternetConnectivityChanges(onAvailable = {
        viewModel.reconnection(text)
    }, onLost = {})
}

@Composable
fun ItemCard(
    item: CardBrief,
    onItemClicked: (id: String) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .animateContentSize()
            .clickable { onItemClicked(item.id) }
            .padding(5.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            CustomImage(item.image, item.name, 250.dp)
            Text(
                text = item.name,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                minLines = 1
            )
        }
    }
}

