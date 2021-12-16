package com.homework.newsfeed

import android.app.Application
import com.homework.newsfeed.di.appModule
import com.homework.newsfeed.feature.mainscreen.di.mainScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NewsFeedApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@NewsFeedApp)
            modules(appModule, mainScreenModule)
        }
    }
}