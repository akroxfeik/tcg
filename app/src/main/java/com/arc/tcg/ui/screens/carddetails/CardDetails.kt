package com.arc.tcg.ui.screens.carddetails

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.arc.tcg.data.model.TCGCardDetail
import com.arc.tcg.utils.ImageQuality
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
                .fillMaxSize()
                .padding(10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = item.name,
                fontSize = 20.sp,
                modifier = Modifier.padding(5.dp)
            )
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                SubcomposeAsyncImage(
                    model = getImage(item.image, ImageQuality.HIGH),
                    contentDescription = item.name,
                    modifier = Modifier.size(400.dp),
                    loading = {
                        CircularProgressIndicator(Modifier.size(25.dp))
                    },
                    contentScale = ContentScale.Fit,
                )
            }
        }
    }
}