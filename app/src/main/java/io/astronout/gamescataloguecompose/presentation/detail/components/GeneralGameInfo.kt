package io.astronout.gamescataloguecompose.presentation.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import io.astronout.core.components.Gap
import io.astronout.core.domain.model.Game
import io.astronout.core.theme.Accent10
import io.astronout.core.theme.Accent50
import io.astronout.core.theme.Neutral40
import io.astronout.core.theme.Neutral50
import io.astronout.core.utils.ConverterDate
import io.astronout.core.utils.convertDateTo
import io.astronout.gamescataloguecompose.presentation.home.components.RatingBar
import io.astronout.gamescataloguecompose.presentation.home.components.TagGroup

@Composable
fun GeneralGameInfo(
    game: Game,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(36.dp)
        ) {
            Column {
                Text(
                    text = "Metascore",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Neutral40
                )
                Gap(size = 8.dp)
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Accent10)
                ) {
                    Text(
                        text = if (game.metacritic != 0) game.metacritic.toString() else "-",
                        style = MaterialTheme.typography.titleSmall,
                        color = Accent50,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
            Column {
                Text(
                    text = "Rating",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Neutral40
                )
                Gap(size = 8.dp)
                RatingBar(
                    rating = game.rating.toFloat(),
                    modifier = Modifier
                        .height(16.dp)
                )
            }
        }
        Gap(24.dp)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            Column {
                Text(
                    text = "Released",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Neutral40
                )
                Gap(size = 8.dp)
                Text(
                    text = game.released.convertDateTo(ConverterDate.FULL_DATE),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Neutral50
                )
            }
            Column {
                Text(
                    text = "Genre",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Neutral40
                )
                Gap(size = 8.dp)
                TagGroup(tag = game.genres)
            }
        }
    }
}