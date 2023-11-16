package io.astronout.gamescataloguecompose.presentation.search

import io.astronout.core.domain.model.Game

data class SearchScreenState(
    val games: List<Game> = emptyList(),
    val query: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)