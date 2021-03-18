package com.example.tddandroidcourse.outsideinExample.unit

import com.example.tddandroidcourse.outsideinExample.utils.MainCoroutineScopeRule
import com.example.tddandroidcourse.outsideinexample.Car
import com.example.tddandroidcourse.outsideinexample.Engine
import io.mockk.MockKAnnotations
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CarShould {

    private val engine = mockk<Engine>(relaxed = true)

    private val car = Car(5.0, engine)

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()


    @Test
    fun loosingFuelWhenItTurnsOn() = runBlockingTest {
        car.turnOn()

        assertThat(car.fuel).isEqualTo(4.5)
    }

    @Test
    fun turnOnItsEngine() = runBlockingTest {
        car.turnOn()

        verify { runBlockingTest { engine.turnOn() } }
    }

}