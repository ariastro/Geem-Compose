package io.astronout.gamescataloguecompose.presentation.videoplayer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun VideoPlayer(
    url: String
) {
    val context = LocalContext.current

    val mediaItem = MediaItem.Builder()
        .setUri(url)
        .setMediaId(url)
        .setTag(url)
        .setMediaMetadata(
            MediaMetadata.Builder()
                .build()
        )
        .build()

    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            this.setMediaItem(mediaItem)
            this.prepare()
            this.playWhenReady = true
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Black)
    ) {
        DisposableEffect(
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = {
                    PlayerView(context).apply {
                        player = exoPlayer
                    }
                }
            )
        ) {
            onDispose {
                exoPlayer.release()
            }
        }
    }
}