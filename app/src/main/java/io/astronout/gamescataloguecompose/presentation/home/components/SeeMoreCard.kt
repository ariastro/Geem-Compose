package io.astronout.gamescataloguecompose.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.astronout.core.theme.Neutral20
import io.astronout.core.theme.Neutral50

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun SeeMoreCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(100.dp))
            .border(width = 1.dp, color = Neutral20, shape = RoundedCornerShape(100.dp))
            .background(Color.White)
            .clickable {  }
    ) {
        Text(
            text = "See more",
            style = MaterialTheme.typography.bodySmall,
            color = Neutral50,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        )
    }
}