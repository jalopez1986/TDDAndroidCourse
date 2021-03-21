package com.example.tddandroidcourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tddandroidcourse.playlist.PlaylistFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}