package io.astronout.gamescataloguecompose.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.astronout.core.theme.Primary50
import io.astronout.gamescataloguecompose.R

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 18.dp, horizontal = 24.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Primary50),
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = "Games",
            style = MaterialTheme.typography.titleLarge,
            color = Primary50,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1F)
                .padding(horizontal = 16.dp)
        )
        Icon(
            imageVector = Icons.Default.Settings,
            contentDescription = "",
            tint = Primary50,
            modifier = Modifier.size(24.dp)
        )
    }
}