package com.arc.tcg.ui.screens.cardslist

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.arc.tcg.data.model.CardBrief
import com.arc.tcg.ui.screens.CustomImage
import com.arc.tcg.ui.screens.LoadingBar

@Composable
fun CardList(viewModel: CardListViewModel = hiltViewModel(), onItemClicked: (itemId: String) -> Unit) {
    Box {
        Column(Modifier.fillMaxSize()) {
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
    when {
        viewModel.state.isLoading -> LoadingBar()
    }
    if(viewModel.state.isLoading) LoadingBar()
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

