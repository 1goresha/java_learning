package com.example.innopolisonlinecinema.domain

import com.example.innopolisonlinecinema.base.attempt
import com.example.innopolisonlinecinema.data.api.MoviesRepository

class MovieInteractor(private val repository: MoviesRepository) {
    suspend fun getMovies() = attempt {
        repository.getMovies()
    }
}