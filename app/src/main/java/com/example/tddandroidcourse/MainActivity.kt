package com.example.tddandroidcourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tddandroidcourse.outsideinexample.Car
import com.example.tddandroidcourse.outsideinexample.Engine

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, PlaylistFragment.newInstance())
                .commit()
        }
    }
}