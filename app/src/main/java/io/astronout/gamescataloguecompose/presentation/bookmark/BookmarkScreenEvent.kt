package io.astronout.gamescataloguecompose.presentation.bookmark

import io.astronout.core.domain.model.Game

sealed class BookmarkScreenEvent {
    data class NavigateToDetailScreen(val game: Game): BookmarkScreenEvent()
}