package io.astronout.gamescataloguecompose.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import io.astronout.core.components.Gap
import io.astronout.core.theme.Neutral50
import io.astronout.core.theme.Primary50
import io.astronout.gamescataloguecompose.R

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_ghost),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Primary50),
            modifier = Modifier.size(56.dp)
        )
        Gap(size = 12.dp)
        Column(
            modifier = Modifier.weight(1F),
        ) {
            Text(
                text = "GEEM",
                style = MaterialTheme.typography.titleLarge,
                color = Primary50,
            )
            Text(
                text = "Largest Game Database",
                style = MaterialTheme.typography.bodyLarge,
                color = Neutral50,
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_setting),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Primary50),
            modifier = Modifier.size(24.dp)
        )
    }
}