package com.example.tddandroidcourse.outsideinExample.unit

import com.example.tddandroidcourse.outsideinExample.utils.MainCoroutineScopeRule
import com.example.tddandroidcourse.outsideinexample.Car
import com.example.tddandroidcourse.outsideinexample.Engine
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CarShould {

    private val engine: Engine = mock()

    init {
        runBlockingTest {
            whenever(engine.turnOn()).thenReturn(flow {
                delay(2000)
                emit(2000)
                delay(2000)
                emit(50)
                delay(2000)
                emit(95)
            })
        }
    }

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

        verify(engine, times(1)).turnOn()
    }

}