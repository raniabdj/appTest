package com.example.application_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.application_test.feature.liste.view.UserFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, UserFragment())
            .commit()
        setContentView(R.layout.activity_main)
    }
}