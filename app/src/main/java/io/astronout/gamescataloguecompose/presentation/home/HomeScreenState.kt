package io.astronout.gamescataloguecompose.presentation.home

import io.astronout.core.domain.model.Game

data class HomeScreenState(
    val games: List<Game> = emptyList(),
    val hotGames: List<Game> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)