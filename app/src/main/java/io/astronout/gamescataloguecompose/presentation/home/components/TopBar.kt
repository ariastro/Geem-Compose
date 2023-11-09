package io.astronout.gamescataloguecompose.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.astronout.core.components.Gap
import io.astronout.core.theme.Neutral50
import io.astronout.core.theme.Primary50

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 18.dp, horizontal = 24.dp)
    ) {
//        Image(
//            painter = painterResource(id = R.drawable.ic_menu),
//            contentDescription = null,
//            colorFilter = ColorFilter.tint(Primary50),
//            modifier = Modifier.size(24.dp)
//        )
        Column(
            modifier = Modifier
                .weight(1F)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "GEEM",
                style = MaterialTheme.typography.titleLarge,
                color = Primary50,
                textAlign = TextAlign.Center,
            )
            Gap(size = 2.dp)
            Text(
                text = "Largest Game Database",
                style = MaterialTheme.typography.bodyLarge,
                color = Neutral50,
                textAlign = TextAlign.Center
            )
        }
//        Icon(
//            imageVector = Icons.Default.Settings,
//            contentDescription = "",
//            tint = Primary50,
//            modifier = Modifier.size(24.dp)
//        )
    }
}