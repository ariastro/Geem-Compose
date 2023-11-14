package io.astronout.gamescataloguecompose.presentation.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import io.astronout.core.domain.model.Game
import io.astronout.core.domain.usecase.GameUsecase
import io.astronout.gamescataloguecompose.presentation.destinations.DetailScreenDestination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(private val gameUsecase: GameUsecase): ViewModel() {

    private lateinit var navigator: DestinationsNavigator

    private val _uiState = MutableStateFlow(BookmarkScreenState())
    val uiState = _uiState.asStateFlow()

    fun onInit(navigator: DestinationsNavigator) {
        this.navigator = navigator
        getBookmarkedGames()
    }

    private fun getBookmarkedGames() {
        gameUsecase.getBookmarkedGames().onEach { games ->
            _uiState.update { it.copy(games = games) }
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: BookmarkScreenEvent) {
        when (event) {
            is BookmarkScreenEvent.NavigateToDetailScreen -> navigateToDetailScreen(event.game)
        }
    }

    private fun navigateToDetailScreen(game: Game) {
        navigator.navigate(DetailScreenDestination(game))
    }

}