package ru.tinkoff.fintech.task3

import java.util.Date

class Flight (val vehicle: SpaceVehicle, var startDate: Date, var startPlace: String) {
    fun launch(): String{
        val result = "${vehicle.name} launch on $startDate by ${vehicle.creator} at $startPlace."
        println(result)
        vehicle.run()
        return result
    }
}