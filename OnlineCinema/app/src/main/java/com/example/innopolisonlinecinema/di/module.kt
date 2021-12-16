package com.example.innopolisonlinecinema.di

import com.example.innopolisonlinecinema.data.api.MoviesApi
import com.example.innopolisonlinecinema.data.api.MoviesRemoteSource
import com.example.innopolisonlinecinema.data.api.MoviesRepository
import com.example.innopolisonlinecinema.data.api.MoviesRepositoryImpl
import com.example.innopolisonlinecinema.domain.MovieInteractor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

//"https://gist.githubusercontent.com/LukyanovAnatoliy/eca5141dedc79751b3d0b339649e06a3/raw/38f9419762adf27c34a3f052733b296385b6aa8d/"
const val BASE_URL = "https://gist.githubusercontent.com/LukyanovAnatoliy/"

val appModule = module {

    single {
        OkHttpClient.Builder()
            .build()
    }

    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(get())
            .build()
    }

    single<MoviesApi> {
        get<Retrofit>().create()
    }

    single<MoviesRemoteSource> {
        MoviesRemoteSource(get<MoviesApi>())
    }

    single<MoviesRepository> {
        MoviesRepositoryImpl(get<MoviesRemoteSource>())
    }

    single<MovieInteractor> {
        MovieInteractor(get<MoviesRepository>())
    }
}