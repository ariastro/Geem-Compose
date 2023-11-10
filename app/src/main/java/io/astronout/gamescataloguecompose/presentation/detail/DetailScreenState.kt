package io.astronout.gamescataloguecompose.presentation.detail

import io.astronout.core.domain.model.Game

data class DetailScreenState(
    val game: Game? = null,
    val trailerUrl: String? = null,
    val isLoading: Boolean = false,
    val shareSheetGame: Game? = null,
    val error: String? = null
)