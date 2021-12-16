package com.example.innopolisonlinecinema.data.api

import com.example.innopolisonlinecinema.data.toDomain
import com.example.innopolisonlinecinema.domain.model.MovieDomainModel

class MoviesRepositoryImpl(private val remoteSource: MoviesRemoteSource) : MoviesRepository {
    override suspend fun getMovies(): List<MovieDomainModel> {
        return remoteSource.getMovies().results.map { it -> it.toDomain() }
    }
}