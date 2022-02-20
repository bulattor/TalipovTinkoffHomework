package ru.tinkoff.homework.task1

import java.util.Date

class Flight (val vehicle: SpaceVehicle, var startDate: Date, var startPlace: String) {
    fun launch(){
        println("${vehicle.name} launch on $startDate by ${vehicle.creator} at $startPlace.")
        vehicle.run()
    }
}