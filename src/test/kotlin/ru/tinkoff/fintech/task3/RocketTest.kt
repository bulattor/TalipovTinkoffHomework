package ru.tinkoff.fintech.task3

import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class RocketTest {

    @ParameterizedTest
    @CsvSource("1", "0", "-23")
    fun `проверка detachStage при невозможности выполнения`(s: Int) {
        val rocket = Rocket(1, "someName", "someCreator", s)
        rocket.detachStage()

        assertEquals(rocket.stages, s)
    }

    @ParameterizedTest
    @CsvSource("2", "13", "125")
    fun `проверка detachStage при нормальном выполнении`(s: Int) {
        val rocket = Rocket(1, "someName", "someCreator", s)
        rocket.detachStage()

        assertEquals(rocket.stages, s-1)
    }
}