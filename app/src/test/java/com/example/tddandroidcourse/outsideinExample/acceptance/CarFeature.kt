package com.example.tddandroidcourse.outsideinExample.acceptance


import com.example.tddandroidcourse.outsideinexample.Car
import com.example.tddandroidcourse.outsideinexample.Engine
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CarFeature {
    private val engine = Engine()
    private val car = Car(6.0, engine )

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() {

        car.turnOn()

        assertThat(car.fuel).isEqualTo(5.5)
    }

    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperature() {
        car.turnOn()

        assertThat(car.engine.temperature).isEqualTo(95)
        assertThat(car.engine.isTurnedOn).isTrue()

    }
}