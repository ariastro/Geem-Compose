package io.astronout.gamescataloguecompose.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.astronout.core.components.Gap
import io.astronout.core.domain.model.Game
import io.astronout.core.theme.Primary80
import io.astronout.core.utils.NetworkImage
import io.astronout.gamescataloguecompose.presentation.home.HomeScreenEvent

@Composable
fun GameItemHorizontal(
    modifier: Modifier = Modifier,
    game: Game,
    onEvent: (HomeScreenEvent) -> Unit)
{
    Column(
        modifier = modifier
            .width(140.dp)
            .clickable {
                onEvent(HomeScreenEvent.NavigateToDetailScreen(game))
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NetworkImage(
            url = game.backgroundImage,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(5.dp))
        )
        Gap(size = 12.dp)
        Text(
            text = game.name,
            style = MaterialTheme.typography.bodyLarge,
            color = Primary80,
            textAlign = TextAlign.Center
        )
        Gap(size = 8.dp)
        RatingBar(
            rating = game.rating.toFloat(),
            modifier = Modifier.height(10.dp)
        )
    }
}