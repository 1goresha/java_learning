package com.example.innopolisonlinecinema.domain.model

data class MovieDomainModel(
    val id: Int,
    val genres: List<MovieGenreDomainModel>,
    val originalTitle: String,
    val overview: String,
    val releaseDate: String,
    val posterPath: String,
    val title: String,
    val video: String,
    val voteAverage: Double
)