package ru.tinkoff.fintech.task3

interface SpaceVehicle {
    val id: Int
    val name: String
    val creator: String

    fun run(){
        println("$name is running...")
    }

    fun dock(dv: SpaceVehicle){
        println("$name is docking to ${dv.name}")
    }

    fun releaseCargo()
}