package io.astronout.gamescataloguecompose.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import io.astronout.core.domain.model.Game
import io.astronout.core.domain.usecase.GameUsecase
import io.astronout.core.vo.Resource
import io.astronout.gamescataloguecompose.presentation.destinations.VideoPlayerDestination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val gameUsecase: GameUsecase): ViewModel() {

    private lateinit var navigator: DestinationsNavigator

    private val _uiState = MutableStateFlow(DetailScreenState())
    val uiState = _uiState.asStateFlow()

    fun onInit(game: Game, navigator: DestinationsNavigator) {
        this.navigator = navigator
        _uiState.update { it.copy(game = game) }
        fetchDetailGame(game.id)
        fetchGameTrailer(game.id)
    }

    fun onEvent(event: DetailScreenEvent) {
        when (event) {
            is DetailScreenEvent.NavigateBack -> navigateBack()
            is DetailScreenEvent.BookmarkGame -> setBookmarked(event.id, event.bookmarked)
            is DetailScreenEvent.ShareGame -> shareGame(event.game, event.dismissed)
            is DetailScreenEvent.PlayTrailer -> playTrailer(event.url)
        }
    }

    private fun fetchDetailGame(gameId: Long) {
        gameUsecase.getGameDetails(gameId).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _uiState.update {
                        it.copy(isLoading = false, error = result.message)
                    }
                }
                is Resource.Loading -> {
                    _uiState.update {
                        it.copy(isLoading = true)
                    }
                }
                is Resource.Success -> {
                    _uiState.update {
                        it.copy(game = result.data, isLoading = false, error = null)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun fetchGameTrailer(gameId: Long) {
        gameUsecase.fetchGameTrailer(gameId).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _uiState.update {
                        it.copy(isLoading = false, error = result.message)
                    }
                }
                is Resource.Loading -> {
                    _uiState.update {
                        it.copy(isLoading = true)
                    }
                }
                is Resource.Success -> {}
            }
        }.launchIn(viewModelScope)
    }

    private fun shareGame(game: Game?, isDismissed: Boolean) {
        _uiState.update { it.copy(shareSheetGame = if (isDismissed) null else game) }
    }

    private fun setBookmarked(id: Long, isBookmarked: Boolean) {
        viewModelScope.launch {
            gameUsecase.setIsFavorites(isBookmarked, id)
        }
    }

    private fun playTrailer(url: String) {
        navigator.navigate(VideoPlayerDestination(url))
    }

    private fun navigateBack() {
        navigator.popBackStack()
    }

}