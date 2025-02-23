package com.arc.tcg.ui.screens.cardslist

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.arc.tcg.data.model.TCGCard
import com.arc.tcg.ui.screens.LoadingBar

@Composable
fun CardList(viewModel: CardListViewModel = hiltViewModel()) {
    Box {
        Column(Modifier.fillMaxSize()) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(128.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(viewModel.state.cards) { item ->
                    ItemCard(item = item, onItemClicked = { id ->
                        Log.d("TESTE", "Card ID: $id")
                    })
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
    item: TCGCard,
    onItemClicked: (id: String) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .animateContentSize()
            .clickable { onItemClicked(item.id) }
            .padding(5.dp)
    ) {
        Column(
            modifier = Modifier
                .size(200.dp)
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            SubcomposeAsyncImage(
                model = getImage(item.image),
                contentDescription = item.name,
                modifier = Modifier.size(100.dp),
                loading = {
                    CircularProgressIndicator(Modifier.size(25.dp))
                },
                contentScale = ContentScale.Crop
            )
            Text(
                text = item.name,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                minLines = 2
            )
        }
    }
}

fun getImage(url: String?): String {
    return "$url/low.png"
}