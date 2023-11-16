package io.astronout.gamescataloguecompose.presentation.search

import io.astronout.core.domain.model.Game

sealed class SearchScreenEvent {
    data class NavigateToDetailScreen(val game: Game): SearchScreenEvent()
    data class OnSearchQueryChange(
        val query: String
    ) : SearchScreenEvent()
}