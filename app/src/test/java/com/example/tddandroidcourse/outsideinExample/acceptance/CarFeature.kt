package com.example.tddandroidcourse.outsideinExample.acceptance


import com.example.tddandroidcourse.outsideinexample.Car
import org.junit.Assert.assertEquals
import org.junit.Test

class CarFeature {
    private val car = Car(6.0);

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() {

        car.turnOn();

        assertEquals(5.5, car.fuel,0.0)
    }
}