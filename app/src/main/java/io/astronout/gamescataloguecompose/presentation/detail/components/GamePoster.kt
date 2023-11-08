package io.astronout.gamescataloguecompose.presentation.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.astronout.core.components.Gap
import io.astronout.core.domain.model.Game
import io.astronout.core.theme.Primary70
import io.astronout.core.utils.NetworkImage
import io.astronout.gamescataloguecompose.R
import io.astronout.gamescataloguecompose.presentation.detail.DetailScreenEvent

@Composable
fun GamePoster(
    modifier: Modifier = Modifier,
    game: Game,
    onEvent: (DetailScreenEvent) -> Unit)
{
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        NetworkImage(
            url = game.backgroundImage,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.2F))
        )
        Row(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 18.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple(bounded = false),
                        onClick = {
                            onEvent(DetailScreenEvent.NavigateBack)
                        }
                    )
            )
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
            )
        }
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.White, CircleShape)
                    .clickable {}
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Primary70),
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.Center)
                )
            }
            Gap(size = 8.dp)
            Text(
                text = stringResource(id = R.string.action_play_trailer),
                style = MaterialTheme.typography.titleSmall,
                color = Color.White
            )
        }
    }
}