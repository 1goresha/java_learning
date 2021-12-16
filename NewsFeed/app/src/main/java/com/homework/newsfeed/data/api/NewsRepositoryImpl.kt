package com.homework.newsfeed.data.api

import com.homework.newsfeed.data.toDomain
import com.homework.newsfeed.feature.mainscreen.domain.model.NewsDomainModel

class NewsRepositoryImpl(private val source: NewsRemoteSource) : NewsRepository {
    override suspend fun fetchNews(): List<NewsDomainModel> {
        return source.fetchNews().articles.map { article -> article.toDomain() }
    }
}