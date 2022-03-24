package ru.tinkoff.fintech.task1

import java.util.*

fun main(){
    val starship = Rocket(1, "Starship", "SpaceX", 2)
    val skylon = SpacePlane(2, "Skylon", "Reaction Engines Limited")
    val sls = Rocket(3, "SLS", "NASA", 2)

    val list = listOf<SpaceVehicle>(starship, skylon)

    list.forEach{
        it.run()
    }

    starship.detachStage()
    starship.releaseCargo()

    skylon.changeEnginesMode()
    skylon.dock(starship)
    skylon.releaseCargo()

    println()

    val slsFlight = Flight(sls, Date(), "John Fitzgerald Kennedy Space Center")
    slsFlight.launch()

    //polymorphism example
    println()
    (skylon as SpaceVehicle).run()
    println()
    (starship as SpaceVehicle).run()
}