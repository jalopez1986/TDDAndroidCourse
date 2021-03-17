package com.example.tddandroidcourse.outsideinExample.unit

import com.example.tddandroidcourse.outsideinexample.Car
import org.junit.Assert.assertEquals
import org.junit.Test

class CarShould {
    private val car = Car(5.0)

    @Test
    fun loosingFuelWhenItTurnsOn() {
        car.turnOn()

        assertEquals(4.5,car.fuel,0.0)

    }

}