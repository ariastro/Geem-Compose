package io.astronout.gamescataloguecompose.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import io.astronout.core.components.Gap
import io.astronout.core.theme.Neutral50
import io.astronout.core.theme.Primary80
import io.astronout.core.theme.Yellow
import io.astronout.gamescataloguecompose.R

@Composable
fun GameItemHorizontal(modifier: Modifier = Modifier) {
    Column(modifier.width(140.dp)) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(5.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.poster),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
        Gap(size = 12.dp)
        Text(
            text = "Spiderman: No Way Home",
            style = MaterialTheme.typography.bodyLarge,
            color = Primary80
        )
        Gap(size = 8.dp)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = null,
                tint = Yellow,
                modifier = Modifier.size(12.dp)
            )
            Gap(size = 2.dp)
            Text(
                text = "9.1/10 IMDb",
                style = MaterialTheme.typography.labelMedium,
                color = Neutral50
            )
        }
    }
}