package io.astronout.gamescataloguecompose.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.astronout.core.components.Gap
import io.astronout.gamescataloguecompose.presentation.home.components.GameItem
import io.astronout.gamescataloguecompose.presentation.home.components.GameItemHorizontal
import io.astronout.gamescataloguecompose.presentation.home.components.SectionTitle
import io.astronout.gamescataloguecompose.presentation.home.components.TopBar

@Preview
@Composable
fun HomeScreen() {
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
                    items(5) {
                        GameItemHorizontal()
                    }
                }
            }
            item {
                Gap(vertical = 24.dp)
                SectionTitle(title = "Popular Games")
                Gap(vertical = 8.dp)
            }
            items(4) {
                GameItem(modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp))
            }
            item {
                Gap(vertical = 8.dp)
            }
        }
    }
}