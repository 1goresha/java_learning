package com.example.innopolisonlinecinema.data

import com.example.innopolisonlinecinema.data.api.model.Genre
import com.example.innopolisonlinecinema.data.api.model.Result
import com.example.innopolisonlinecinema.domain.model.MovieDomainModel
import com.example.innopolisonlinecinema.domain.model.MovieGenreDomainModel

fun Genre.toDomain(): MovieGenreDomainModel {
    return MovieGenreDomainModel(
        genre = genre
    )
}

fun Result.toDomain(): MovieDomainModel {

    val genres: List<MovieGenreDomainModel> = genres.map { it ->
        it.toDomain()
    }

    return MovieDomainModel(
        id = id,
        genres = genres,
        originalTitle = originalTitle,
        overview = overview,
        releaseDate = releaseDate,
        posterPath = posterPath,
        title = title,
        video = video,
        voteAverage = voteAverage
    )
}