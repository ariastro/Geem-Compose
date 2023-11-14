package io.astronout.gamescataloguecompose.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import io.astronout.gamescataloguecompose.presentation.home.HomeScreenEvent

@Composable
fun GameItem(
    game: Game,
    modifier: Modifier = Modifier,
    onEvent: (Game) -> Unit)
{
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable {
                onEvent(game)
            }
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
            TagGroup(tag = game.genres, isLimited = true)
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