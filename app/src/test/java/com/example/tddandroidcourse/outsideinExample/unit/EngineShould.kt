package com.example.tddandroidcourse.outsideinExample.unit

import com.example.tddandroidcourse.outsideinExample.utils.MainCoroutineScopeRule
import com.example.tddandroidcourse.outsideinexample.Engine
import kotlinx.coroutines.test.runBlockingTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test

class EngineShould {
    private val engine = Engine()

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun turnOn() = runBlockingTest {
        engine.turnOn()

        assertThat(engine.isTurnedOn).isTrue()
    }

    @Test
    fun riseTheTemperatureWhenTurnsOn() = runBlockingTest {
        engine.turnOn()

        assertThat(engine.temperature).isEqualTo(95)
    }
}