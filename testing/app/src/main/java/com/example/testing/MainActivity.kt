package com.example.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val numbers = (0..99).toList()
//    val doubleNumbers = numbers.map { it * 2 }
    val doubleNumbers = numbers.map({a: Int -> a * 2})


}