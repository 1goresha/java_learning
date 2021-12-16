package com.example.innopolisonlinecinema.features.movies_list_screen.di

import com.example.innopolisonlinecinema.features.movies_list_screen.ui.MoviesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Di  module for movies list feature
 */
val moviesListModule = module {
    viewModel {
        MoviesListViewModel(get())
    }
}