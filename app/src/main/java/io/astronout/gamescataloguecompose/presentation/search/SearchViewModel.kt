package io.astronout.gamescataloguecompose.presentation.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import io.astronout.core.domain.model.Game
import io.astronout.core.domain.usecase.GameUsecase
import io.astronout.core.vo.Resource
import io.astronout.gamescataloguecompose.presentation.destinations.DetailScreenDestination
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val gameUsecase: GameUsecase) : ViewModel() {

    private lateinit var navigator: DestinationsNavigator
    private var searchJob: Job? = null

    private val _uiState = MutableStateFlow(SearchScreenState())
    val uiState = _uiState.asStateFlow()

    fun onInit(navigator: DestinationsNavigator) {
        this.navigator = navigator
    }

    fun onEvent(event: SearchScreenEvent) {
        when (event) {
            is SearchScreenEvent.NavigateToDetailScreen -> navigateToDetailScreen(event.game)
            is SearchScreenEvent.OnSearchQueryChange -> onSearchQueryChanged(event.query)
        }
    }

    private fun onSearchQueryChanged(query: String) {
        _uiState.update {
            it.copy(query = query)
        }
        Log.d("checkQuery", query)
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500L)
            if (query.isNotEmpty()) {
                searchGames(query)
            } else {
                _uiState.update {
                    it.copy(games = emptyList(), error = null, isLoading = false)
                }
            }
        }
    }

    private fun searchGames(query: String) {
        gameUsecase.searchGames(query).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _uiState.update {
                        it.copy(error = result.message, isLoading = false)
                    }
                }

                is Resource.Loading -> {
                    _uiState.update {
                        it.copy(isLoading = true)
                    }
                }

                is Resource.Success -> {
                    _uiState.update {
                        it.copy(games = result.data, error = null, isLoading = false)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun navigateToDetailScreen(game: Game) {
        navigator.navigate(DetailScreenDestination(game))
    }

}