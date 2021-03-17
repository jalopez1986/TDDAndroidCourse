package com.example.tddandroidcourse.outsideinExample.unit

import com.example.tddandroidcourse.outsideinexample.Car
import com.example.tddandroidcourse.outsideinexample.Engine
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CarShould {

    private val engine = mockk<Engine>(relaxed = true)

    private val car = Car(5.0, engine)

    @Test
    fun loosingFuelWhenItTurnsOn() {
        car.turnOn()

        assertThat(car.fuel).isEqualTo(4.5)
    }

    @Test
    fun turnOnItsEngine() {
        car.turnOn()

        verify(exactly = 1) {engine.turnOn() }
    }

}