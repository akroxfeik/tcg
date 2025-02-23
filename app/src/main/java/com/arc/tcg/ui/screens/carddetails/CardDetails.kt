package com.arc.tcg.ui.screens.carddetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.arc.tcg.R
import com.arc.tcg.data.model.CardBriefDetails
import com.arc.tcg.ui.screens.CustomImage
import com.arc.tcg.ui.screens.TextProperty

@Composable
fun CardDetails(viewModel: CardDetailsViewModel = hiltViewModel()) {
    Box {
        CardDetails(viewModel.state.card)
    }
}

@Composable
fun CardDetails(item: CardBriefDetails?) {
    item?.let {
        Column(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = item.name!!,
                fontSize = 20.sp,
                modifier = Modifier.padding(5.dp)
            )
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CustomImage(item.image, item.name, 400.dp)
            }
            item.description?.let {
                TextProperty(item.description, R.string.description)
            }
            item.rarity?.let {
                TextProperty(item.rarity, R.string.rarity)
            }
            item.evolveFrom?.let {
                TextProperty(item.evolveFrom, R.string.evolveFrom)
            }
        }
    }
}