package io.astronout.gamescataloguecompose.presentation.bookmark

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.astronout.core.components.Gap
import io.astronout.core.theme.Neutral50
import io.astronout.core.theme.Primary50
import io.astronout.gamescataloguecompose.R
import io.astronout.gamescataloguecompose.presentation.home.components.GameItem

@Destination
@Composable
fun BookmarkScreen(
    navigator: DestinationsNavigator,
    viewModel: BookmarkViewModel = hiltViewModel()
) {

    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.onInit(navigator)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        contentPadding = PaddingValues(vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = stringResource(id = R.string.title_bookmark),
                style = MaterialTheme.typography.headlineMedium,
                color = Primary50
            )
            Text(
                text = stringResource(id = R.string.label_bookmark_description),
                style = MaterialTheme.typography.bodyMedium,
                color = Neutral50
            )
        }
        if (state.games.isNotEmpty()) {
            items(items = state.games, key = { it.id }) {
                GameItem(
                    game = it,
                    onEvent = { game ->
                        viewModel.onEvent(BookmarkScreenEvent.NavigateToDetailScreen(game))
                    }
                )
            }
        }
    }
}