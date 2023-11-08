package io.astronout.gamescataloguecompose.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import io.astronout.core.domain.usecase.GameUsecase
import io.astronout.core.vo.Resource
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

    fun onInit(gameId: Long, navigator: DestinationsNavigator) {
        this.navigator = navigator
        fetchDetailGame(gameId)
    }

    fun onEvent(event: DetailScreenEvent) {
        when (event) {
            DetailScreenEvent.NavigateBack -> navigateBack()
            is DetailScreenEvent.BookmarkGame -> setBookmarked(event.id, event.bookmarked)
            is DetailScreenEvent.ShareGame -> Unit
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

    private fun setBookmarked(id: Long, isBookmarked: Boolean) {
        viewModelScope.launch {
            gameUsecase.setIsFavorites(isBookmarked, id)
        }
    }

    private fun navigateBack() {
        navigator.popBackStack()
    }

}