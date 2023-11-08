package io.astronout.gamescataloguecompose.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TagGroup(
    modifier: Modifier = Modifier,
    tag: List<String>,
    isLimited: Boolean = false)
{
    val limitedGenres = remember(tag) {
        if (tag.size >= 3) 3 else tag.size
    }

    FlowRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(if (isLimited) limitedGenres else tag.size) {
            TagChip(name = tag[it])
        }
    }
}