package io.astronout.gamescataloguecompose.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.astronout.core.components.Gap
import io.astronout.core.theme.Neutral10
import io.astronout.core.theme.Neutral40
import io.astronout.core.theme.Primary50
import io.astronout.core.theme.Primary70
import io.astronout.gamescataloguecompose.R
import io.astronout.gamescataloguecompose.presentation.home.components.GameItem

@Destination
@Composable
fun SearchScreen(
    navigator: DestinationsNavigator,
    viewModel: SearchViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.onInit(navigator)
    }

    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp)
    ) {
        Gap(size = 48.dp)
        Text(
            text = "What games are you looking for?",
            style = MaterialTheme.typography.headlineMedium,
            color = Primary50
        )
        Gap(size = 24.dp)
        TextField(
            value = state.query,
            onValueChange = {
                viewModel.onEvent(SearchScreenEvent.OnSearchQueryChange(it))
            },
            textStyle = MaterialTheme.typography.bodyLarge,
            placeholder = {
                Text(
                    text = "Search...",
                    color = Neutral40,
                    style = MaterialTheme.typography.bodyLarge
                )
            },
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = null,
                    tint = Primary50
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Neutral10,
                unfocusedContainerColor = Neutral10,
                disabledContainerColor = Neutral10,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledLabelColor = Color.Blue,
            ),
            maxLines = 1,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
        )
        Gap(size = 12.dp)
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items = state.games, key = { it.id }) {
                GameItem(
                    game = it,
                    onEvent = { game ->
                        viewModel.onEvent(SearchScreenEvent.NavigateToDetailScreen(game))
                    }
                )
            }
        }
    }
}