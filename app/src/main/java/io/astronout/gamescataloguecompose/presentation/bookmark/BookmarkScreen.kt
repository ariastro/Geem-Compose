package io.astronout.gamescataloguecompose.presentation.bookmark

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.astronout.core.components.Gap
import io.astronout.core.theme.Primary50
import io.astronout.gamescataloguecompose.presentation.home.components.GameItem
import io.astronout.gamescataloguecompose.presentation.home.components.TopBar

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

    Scaffold(
        topBar = {
            TopBar()
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(padding)
        ) {
//            item {
//                Text(
//                    text = "Saved Games",
//                    style = MaterialTheme.typography.titleLarge,
//                    color = Primary50,
//                    textAlign = TextAlign.Center,
//                )
//                Gap(32.dp)
//            }
            if (state.games.isNotEmpty()) {
                items(items = state.games, key = { it.id }) {
                    GameItem(
                        game = it,
                        onEvent = { game ->
                            viewModel.onEvent(BookmarkScreenEvent.NavigateToDetailScreen(game))
                        },
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                    )
                }
            }
        }
    }
}