package io.astronout.gamescataloguecompose.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.astronout.core.components.Gap
import io.astronout.gamescataloguecompose.presentation.home.components.GameItem
import io.astronout.gamescataloguecompose.presentation.home.components.GameItemHorizontal
import io.astronout.gamescataloguecompose.presentation.home.components.SectionTitle
import io.astronout.gamescataloguecompose.presentation.home.components.TopBar

@Destination(start = true)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
    viewModel: HomeViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = Unit, block = {
        viewModel.onInit(navigator)
    })

    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopBar()
        LazyColumn(contentPadding = PaddingValues(vertical = 8.dp)) {
            item {
                SectionTitle(title = "Hot Games")
            }
            item {
                Gap(vertical = 16.dp)
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(horizontal = 24.dp)
                ) {
                    items(items = state.hotGames, key = { it.id }) {
                        GameItemHorizontal(game = it)
                    }
                }
            }
            item {
                Gap(vertical = 24.dp)
                SectionTitle(title = "Popular Games")
                Gap(vertical = 8.dp)
            }
            items(items = state.games, key = { it.id }) {
                GameItem(game = it, modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp))
            }
            item {
                Gap(vertical = 8.dp)
            }
        }
    }
}