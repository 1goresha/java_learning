package com.example.innopolisonlinecinema.features.movies_list_screen.ui

import com.example.innopolisonlinecinema.base.Event
import com.example.innopolisonlinecinema.domain.model.MovieDomainModel

data class ViewState(
    val movies: List<MovieDomainModel>,
    val errorMessage: String?,
    val isLoad: Boolean
)

sealed class UIEvent : Event {
    data class OnMovieClick(val movie: MovieDomainModel) : UIEvent()
}

sealed class DataEvent : Event {
    object GetMovies : DataEvent()
    data class SuccessMoviesRequest(val movies: List<MovieDomainModel>) : DataEvent()
    data class ErrorMoviesRequest(val errorMessage: String) : DataEvent()
}