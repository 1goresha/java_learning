package com.homework.newsfeed.feature.mainscreen.domain

import com.homework.newsfeed.base.attempt
import com.homework.newsfeed.data.api.NewsRepository

class MainScreenNewsInteractor(private val repository: NewsRepository) {
    suspend fun fetchNews() = attempt { repository.fetchNews() }
}