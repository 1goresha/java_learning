package com.example.innopolisonlinecinema.data.api

import com.example.innopolisonlinecinema.data.api.model.Results
import retrofit2.http.GET

/**
 * Constant for ref to api
 */
const val BASE_MOVIES_PATH =
    "eca5141dedc79751b3d0b339649e06a3/raw/38f9419762adf27c34a3f052733b296385b6aa8d/"

/**
 * Interface api
 */
interface MoviesApi {
    @GET(BASE_MOVIES_PATH)
    suspend fun getMovies(): Results
}