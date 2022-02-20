package ru.tinkoff.homework.task1

class SpacePlane(override val id: Int, override val name: String, override val creator: String) : SpaceVehicle {

    private var enginesOxygenModeOn: Boolean = false

    override fun run() {
        println("$creator\'s $name moves to runway...")
        super.run()
    }

    override fun releaseCargo() {
        println("$name\'s astronauts are in space now.")
    }

    fun changeEnginesMode (){
        enginesOxygenModeOn = !enginesOxygenModeOn
        println("$name\'s engines are now in " + (if(enginesOxygenModeOn) "oxygen" else "air") + " mode.")
    }
}