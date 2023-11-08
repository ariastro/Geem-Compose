package io.astronout.gamescataloguecompose.presentation.home

import io.astronout.core.domain.model.Game

sealed class HomeScreenEvent {
    data class NavigateToDetailScreen(val game: Game): HomeScreenEvent()
}