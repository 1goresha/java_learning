package com.homework.newsfeed.feature.mainscreen.ui

import com.homework.newsfeed.base.Event
import com.homework.newsfeed.feature.mainscreen.domain.model.NewsDomainModel

data class ViewState(
    val articles: List<NewsDomainModel>,
    val errorMessage: String?,
    val isLoading: Boolean
) {
    val isInErrorState: Boolean = errorMessage != null
}


sealed class UIEvent : Event {
    object GetCurrentNews : UIEvent()
    data class OnArticleClick(val article: NewsDomainModel) : UIEvent()
}

sealed class DataEvent : Event {
    object OnDataLoad : DataEvent()
    data class SuccessNewsRequest(
        val articles: List<NewsDomainModel>
    ) : DataEvent()
    data class ErrorNewsRequest(val errorMessage: String) : DataEvent()
}