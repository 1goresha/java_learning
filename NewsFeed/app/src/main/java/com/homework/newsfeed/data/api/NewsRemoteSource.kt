package com.homework.newsfeed.data.api

import com.homework.newsfeed.data.api.model.NewsModel

class NewsRemoteSource(private val api: NewsApi) {
    suspend fun fetchNews(): NewsModel = api.fetchNews()
}