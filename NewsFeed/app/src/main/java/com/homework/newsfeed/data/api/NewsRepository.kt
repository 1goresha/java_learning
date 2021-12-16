package com.homework.newsfeed.data.api

import com.homework.newsfeed.feature.mainscreen.domain.model.NewsDomainModel

interface NewsRepository {
    suspend fun fetchNews(): List<NewsDomainModel>
}