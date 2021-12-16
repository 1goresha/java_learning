package com.example.innopolisonlinecinema.data.api.model

import com.google.gson.annotations.SerializedName

/**
 * A data class for film category
 *
 * For example: Drama, Comedy, etc.
 */
data class Genre(
    @SerializedName("name")
    val genre: String
)
