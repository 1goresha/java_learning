package com.example.innopolisonlinecinema.data.api.model

import com.google.gson.annotations.SerializedName

/**
 * A data class for film
 */
data class Result(
    @SerializedName("id")
    val id: Int,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("video")
    val video: String,
    @SerializedName("vote_average")
    val voteAverage: Double
)