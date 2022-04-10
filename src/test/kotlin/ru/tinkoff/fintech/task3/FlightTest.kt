package ru.tinkoff.fintech.task3

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*

@ExtendWith(MockKExtension::class)
internal class FlightTest {

    @MockK(relaxUnitFun = true)
    lateinit var spacePlane: SpacePlane

    @Test
    fun launch() {
        every { spacePlane.name } returns "name"
        every { spacePlane.creator } returns "creator"

        val date = Date()

        val flight = Flight(spacePlane, date, "startPlace")
        val actual = flight.launch()

        assertAll("свойства заглушки должны быть использованы по одному разу",
            { verify(exactly = 1) { spacePlane.name } },
            { verify(exactly = 1) { spacePlane.creator } },
            { assertEquals("name launch on $date by creator at startPlace.", actual) }
        )
    }
}