package io.astronout.gamescataloguecompose.presentation.detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.astronout.core.components.Gap
import io.astronout.core.theme.Neutral40
import io.astronout.core.theme.Primary70
import io.astronout.core.utils.NetworkImage

@Composable
fun Screenshots(
    urls: List<String>,
    modifier: Modifier = Modifier)
{
    Column(modifier = modifier) {
        Text(
            text = "Screenshots",
            style = MaterialTheme.typography.titleMedium,
            color = Primary70
        )
        Gap(size = 8.dp)
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
        ) {
            items(
                items = urls,
                key = { it }
            ) {
                NetworkImage(
                    url = it,
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .height(200.dp)
                )
            }
        }
    }
}