package com.arc.tcg.ui.screens.carddetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.arc.tcg.data.model.TCGCardDetail
import com.arc.tcg.utils.getImage

@Composable
fun CardDetails(viewModel: CardDetailsViewModel = hiltViewModel()) {
    Box {
        CardDetails(viewModel.state.card)
    }
}

@Composable
fun CardDetails(item: TCGCardDetail?) {
    item?.let {
        Column(
            Modifier
                .padding(10.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = item.name,
                fontSize = 20.sp,
                modifier = Modifier.padding(5.dp)
            )
            Column(Modifier.fillMaxSize()) {
                SubcomposeAsyncImage(
                    model = getImage(item.image),
                    contentDescription = item.name,
                    loading = {
                        CircularProgressIndicator(Modifier.size(25.dp))
                    },
                    contentScale = ContentScale.Crop,
                )
            }
        }
    }
}