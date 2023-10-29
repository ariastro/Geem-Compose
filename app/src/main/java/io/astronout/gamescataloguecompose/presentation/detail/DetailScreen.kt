package io.astronout.gamescataloguecompose.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import io.astronout.core.components.Gap
import io.astronout.core.theme.Neutral40
import io.astronout.core.theme.Neutral50
import io.astronout.core.theme.Primary70
import io.astronout.core.theme.Yellow
import io.astronout.gamescataloguecompose.R
import io.astronout.gamescataloguecompose.presentation.home.components.TagChip

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Destination
@Composable
fun DetailScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy((-30).dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.poster),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.2F))
                )
                Row(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 18.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(bounded = false),
                                onClick = {

                                }
                            )
                    )
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .size(24.dp)
                    )
                }
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .background(Color.White, CircleShape)
                            .clickable {}
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_play),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Primary70),
                            modifier = Modifier
                                .size(24.dp)
                                .align(Alignment.Center)
                        )
                    }
                    Gap(size = 8.dp)
                    Text(
                        text = "Play Trailer",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.White
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                    .background(Color.White)
                    .padding(24.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Spiderman: No Way Home Home Home Home",
                        style = MaterialTheme.typography.titleLarge,
                        color = Primary70,
                        modifier = Modifier.weight(1F)
                    )
                    Gap(size = 8.dp)
                    Image(
                        painter = painterResource(id = R.drawable.ic_bookmark),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Primary70),
                        modifier = Modifier
                            .size(32.dp)
                            .padding(top = 4.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(bounded = false),
                                onClick = {

                                }
                            )
                    )
                }
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
                Gap(size = 16.dp)
                FlowRow(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    repeat(3) {
                        TagChip(name = "Horror")
                    }
                }
                Gap(size = 24.dp)
                Text(
                    text = "Description",
                    style = MaterialTheme.typography.titleMedium,
                    color = Primary70
                )
                Gap(size = 8.dp)
                Text(
                    text = "With Spider-Man's identity now revealed, Peter asks Doctor Strange for help. When a spell goes wrong, dangerous foes from other worlds start to appear, forcing Peter to discover what it truly means to be Spider-Man.",
                    style = MaterialTheme.typography.labelSmall,
                    color = Neutral50,
                )
            }
        }
    }
}