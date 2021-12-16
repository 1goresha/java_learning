package com.example.innopolisonlinecinema.data.api

import com.example.innopolisonlinecinema.domain.model.MovieDomainModel

interface MoviesRepository {
    suspend fun getMovies(): List<MovieDomainModel>
}