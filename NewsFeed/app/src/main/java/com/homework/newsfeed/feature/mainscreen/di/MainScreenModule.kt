package com.homework.newsfeed.feature.mainscreen.di

import com.homework.newsfeed.data.api.NewsApi
import com.homework.newsfeed.data.api.NewsRemoteSource
import com.homework.newsfeed.data.api.NewsRepository
import com.homework.newsfeed.data.api.NewsRepositoryImpl
import com.homework.newsfeed.feature.mainscreen.ui.MainScreenViewModel
import com.homework.newsfeed.feature.mainscreen.domain.MainScreenNewsInteractor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainScreenModule = module {
    viewModel<MainScreenViewModel>{
        MainScreenViewModel(get<MainScreenNewsInteractor>())
    }

    single<NewsRemoteSource> {
        NewsRemoteSource(get<NewsApi>())
    }

    single<NewsRepository> {
        NewsRepositoryImpl(get<NewsRemoteSource>())
    }

    single<MainScreenNewsInteractor> {
        MainScreenNewsInteractor(get<NewsRepository>())
    }
}