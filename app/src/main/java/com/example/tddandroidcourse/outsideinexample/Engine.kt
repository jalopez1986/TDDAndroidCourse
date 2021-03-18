package com.example.tddandroidcourse.outsideinexample

import android.util.Log

class Engine(var temperature: Int = 15,var isTurnedOn: Boolean = false ) {

    fun turnOn() {
        isTurnedOn = true
        Thread.sleep(6000)  //block the main thread
        temperature = 95

        Log.d("COURSE", "Engine has turned on")


    }

}
