package com.example.tddandroidcourse.outsideinExample.unit

import com.example.tddandroidcourse.utils.MainCoroutineScopeRule
import com.example.tddandroidcourse.outsideinexample.Engine
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test

class EngineShould {
    private val engine = Engine()

    @get:Rule
    var coroutinesTestRule =
        MainCoroutineScopeRule()

    @Test
    fun turnOn() = runBlockingTest {
        engine.turnOn()

        assertThat(engine.isTurnedOn).isTrue()
    }

    @Test
    fun riseTheTemperatureGraduallyWhenTurnsOn() = runBlockingTest {
        val flow = engine.turnOn()
        val actual = flow.toList()

        assertThat(actual).isEqualTo(listOf(25, 50, 95))
    }
}