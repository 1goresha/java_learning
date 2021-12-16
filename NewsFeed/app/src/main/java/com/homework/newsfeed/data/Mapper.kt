package com.homework.newsfeed.data

import com.homework.newsfeed.data.api.model.NewsArticleModel
import com.homework.newsfeed.data.api.model.NewsSourceModel
import com.homework.newsfeed.feature.mainscreen.domain.model.NewsDomainModel
import com.homework.newsfeed.feature.mainscreen.domain.model.NewsSourceDomainModel

fun NewsSourceModel.toDomain(): NewsSourceDomainModel =
    NewsSourceDomainModel(
        id = id,
        name = name
    )

fun NewsArticleModel.toDomain(): NewsDomainModel =
    NewsDomainModel(
        source = source.toDomain(),
        author = author,
        title = title,
        description = description,
        url = url,
        urlToImage = urlToImage,
        publishedAt = publishedAt,
        content = content
    )