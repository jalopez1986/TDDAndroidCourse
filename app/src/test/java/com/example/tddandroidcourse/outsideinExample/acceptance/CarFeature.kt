package com.example.tddandroidcourse.outsideinExample.acceptance


import com.example.tddandroidcourse.outsideinExample.utils.MainCoroutineScopeRule
import com.example.tddandroidcourse.outsideinexample.Car
import com.example.tddandroidcourse.outsideinexample.Engine
import kotlinx.coroutines.test.runBlockingTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test

class CarFeature {
    private val engine = Engine()
    private val car = Car(6.0, engine )

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() = runBlockingTest {

        car.turnOn()

        assertThat(car.fuel).isEqualTo(5.5)
    }

    @Test
     fun carIsTurningOnItsEngineAndIncreasesTheTemperatureGradually() = runBlockingTest {
        car.turnOn()

        coroutinesTestRule.advanceTimeBy(2000)
        assertThat(car.engine.temperature).isEqualTo(25)

        coroutinesTestRule.advanceTimeBy(2000)
        assertThat(car.engine.temperature).isEqualTo(50)

        coroutinesTestRule.advanceTimeBy(2000)
        assertThat(car.engine.temperature).isEqualTo(95 )

        assertThat(car.engine.isTurnedOn).isTrue()

    }
}