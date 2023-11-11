package io.astronout.gamescataloguecompose.presentation.detail

import io.astronout.core.domain.model.Game

sealed class DetailScreenEvent {
    data object NavigateBack : DetailScreenEvent()

    data class BookmarkGame(
        val id: Long,
        val bookmarked: Boolean
    ) : DetailScreenEvent()

    data class ShareGame(
        val game: Game? = null,
        val dismissed: Boolean = false
    ) : DetailScreenEvent()

    data class PlayTrailer(
        val url: String
    ) : DetailScreenEvent()

}