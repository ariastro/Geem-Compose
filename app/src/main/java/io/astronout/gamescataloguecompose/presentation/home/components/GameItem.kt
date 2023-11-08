package io.astronout.gamescataloguecompose.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.astronout.core.components.Gap
import io.astronout.core.domain.model.Game
import io.astronout.core.theme.Neutral40
import io.astronout.core.theme.Neutral50
import io.astronout.core.theme.Neutral60
import io.astronout.core.theme.Primary80
import io.astronout.core.theme.Yellow
import io.astronout.core.utils.ConverterDate
import io.astronout.core.utils.NetworkImage
import io.astronout.core.utils.convertDateTo
import io.astronout.gamescataloguecompose.R

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GameItem(game: Game, modifier: Modifier = Modifier) {

    val limitedGenres = remember(game.genres) {
        if (game.genres.size >= 3) 3 else game.genres.size
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        NetworkImage(
            url = game.backgroundImage,
            modifier = Modifier
                .fillMaxHeight()
                .width(85.dp)
                .clip(RoundedCornerShape(5.dp))
        )
        Gap(size = 16.dp)
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = game.name,
                style = MaterialTheme.typography.bodyLarge,
                color = Primary80
            )
            Gap(size = 8.dp)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null,
                    tint = Yellow,
                    modifier = Modifier.size(12.dp)
                )
                Gap(size = 2.dp)
                Text(
                    text = "${game.rating}/5",
                    style = MaterialTheme.typography.labelMedium,
                    color = Neutral60
                )
            }
            Gap(size = 8.dp)
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                maxItemsInEachRow = 3
            ) {
                repeat(limitedGenres) {
                    TagChip(name = game.genres[it])
                }
            }
            Gap(size = 8.dp)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null,
                    tint = Neutral40,
                    modifier = Modifier.size(12.dp)
                )
                Gap(size = 4.dp)
                Text(
                    text = game.released.convertDateTo(ConverterDate.FULL_DATE),
                    style = MaterialTheme.typography.labelSmall,
                    color = Neutral50
                )
            }
        }
    }
}