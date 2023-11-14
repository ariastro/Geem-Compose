package io.astronout.gamescataloguecompose.presentation.bookmark

import io.astronout.core.domain.model.Game

data class BookmarkScreenState(
    val games: List<Game> = emptyList()
)