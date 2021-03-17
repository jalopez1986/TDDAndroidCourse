package com.example.tddandroidcourse.outsideinExample.unit

import com.example.tddandroidcourse.outsideinexample.Engine
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class EngineShould {
    private val engine = Engine()

    @Test
    fun turnOn() {
        engine.turnOn()

        assertThat(engine.isTurnedOn).isTrue()
    }

    @Test
    fun riseTheTemperatureWhenTurnsOn() {
        engine.turnOn()

        assertThat(engine.temperature).isEqualTo(95)
    }
}