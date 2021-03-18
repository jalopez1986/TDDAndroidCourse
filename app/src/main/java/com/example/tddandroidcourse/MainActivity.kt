package com.example.tddandroidcourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tddandroidcourse.outsideinexample.Car
import com.example.tddandroidcourse.outsideinexample.Engine

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val engine = Engine()
        val car = Car(20.00, engine)

        car.turnOn()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}