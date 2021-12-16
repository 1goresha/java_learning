package com.example.innopolisonlinecinema.features.movies_list_screen.ui

import com.example.innopolisonlinecinema.base.BaseViewModel
import com.example.innopolisonlinecinema.base.Event
import com.example.innopolisonlinecinema.domain.MovieInteractor

class MoviesListViewModel(private val interactor: MovieInteractor) : BaseViewModel<ViewState>() {

    init {
        processUiEvent(DataEvent.GetMovies)
    }

    override fun initialViewState(): ViewState {
        return ViewState(movies = listOf(), errorMessage = null, isLoad = false)
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.OnMovieClick -> {
                TODO()
            }
            is DataEvent.GetMovies -> {
                interactor.getMovies().fold(
                    onSuccess = {
                        processDataEvent(DataEvent.SuccessMoviesRequest(it))
                    },
                    onError = {
                        processDataEvent(DataEvent.ErrorMoviesRequest(it.localizedMessage ?: ""))
                    }
                )
            }

            is DataEvent.SuccessMoviesRequest -> {
                return previousState.copy(
                    movies = event.movies,
                    errorMessage = null,
                    isLoad = false
                )
            }

            is DataEvent.ErrorMoviesRequest -> {
                return previousState.copy(
                    errorMessage = event.errorMessage
                )
            }
        }

        return null
    }
}