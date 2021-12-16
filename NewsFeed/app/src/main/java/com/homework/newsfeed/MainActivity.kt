package com.homework.newsfeed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.homework.newsfeed.feature.mainscreen.ui.MainScreenFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainScreenFragment())
            .commit()
    }
}