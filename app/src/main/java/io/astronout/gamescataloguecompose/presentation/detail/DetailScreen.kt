package io.astronout.gamescataloguecompose.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.astronout.core.components.Gap
import io.astronout.core.domain.model.Game
import io.astronout.core.theme.Neutral40
import io.astronout.core.theme.Neutral50
import io.astronout.core.theme.Primary70
import io.astronout.gamescataloguecompose.presentation.detail.components.GamePoster
import io.astronout.gamescataloguecompose.presentation.detail.components.GeneralGameInfo
import io.astronout.gamescataloguecompose.presentation.detail.components.Screenshots
import io.astronout.gamescataloguecompose.presentation.home.components.TagGroup

@Destination
@Composable
fun DetailScreen(
    game: Game,
    navigator: DestinationsNavigator,
    viewModel: DetailViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = Unit, block = {
        viewModel.onInit(game, navigator)
    })

    var savedState by remember {
        mutableStateOf(game.isFavorites)
    }

    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy((-30).dp),
        ) {
            GamePoster(game = game, onEvent = viewModel::onEvent)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                    .background(Color.White)
                    .padding(24.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = game.name,
                        style = MaterialTheme.typography.titleLarge,
                        color = Primary70,
                        modifier = Modifier.weight(1F)
                    )
                    Gap(size = 8.dp)
                    Icon(
                        imageVector = if (savedState) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                        contentDescription = null,
                        tint = Primary70,
                        modifier = Modifier
                            .size(32.dp)
                            .padding(top = 4.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(bounded = false),
                                onClick = {
                                    savedState = !savedState
                                    viewModel.onEvent(
                                        DetailScreenEvent.BookmarkGame(
                                            id = game.id,
                                            bookmarked = savedState
                                        )
                                    )
                                }
                            )
                    )
                }
                Gap(size = 8.dp)
                GeneralGameInfo(game = game)
                Gap(size = 24.dp)
                Text(
                    text = "Description",
                    style = MaterialTheme.typography.titleMedium,
                    color = Primary70
                )
                Gap(size = 8.dp)
                Text(
                    text = state.game?.description ?: "-",
                    style = MaterialTheme.typography.labelSmall,
                    color = Neutral50,
                )
                Gap(size = 24.dp)
                Screenshots(urls = game.shortScreenshots)
                Gap(size = 24.dp)
                Text(
                    text = "Tag",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Neutral40
                )
                Gap(size = 8.dp)
                TagGroup(tag = game.tags.take(8))
            }
        }
    }
}