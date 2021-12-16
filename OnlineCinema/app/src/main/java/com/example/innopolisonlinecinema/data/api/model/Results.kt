package com.example.innopolisonlinecinema.data.api.model

import com.google.gson.annotations.SerializedName

/**
 * Class for list movies
 */
data class Results(
    @SerializedName("results")
    val results: List<Result>
)