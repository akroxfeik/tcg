package com.arc.tcg.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.arc.tcg.R
import com.arc.tcg.utils.getImage

@Composable
fun LoadingBar() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun CustomImage(url: String?, name: String, size: Dp) {
    SubcomposeAsyncImage(
        model = getImage(url),
        contentDescription = name,
        modifier = Modifier.size(size),
        loading = {
            CircularProgressIndicator(Modifier.size(25.dp))
        },
        error = {
            coil.compose.AsyncImage(
                model = R.mipmap.cover,
                contentDescription = name,
                modifier = Modifier.size(250.dp),
                contentScale = ContentScale.Fit
            )
        },
        contentScale = ContentScale.Fit,
        onError = {  }
    )
}

@Composable
fun TextProperty(value: String, id: Int) {
    Text(
        text = stringResource(id),
        fontWeight = FontWeight.Bold
    )
    Text(
        text = value
    )
}