package ru.tinkoff.fintech.task1

class Rocket(override val id: Int, override val name: String, override val creator: String, var stages: Int) :
    SpaceVehicle {

    override fun run() {
        println("$creator\'s $name moves to launch pad...")
        super.run()
    }

    override fun releaseCargo() {
        println("$name releases 100 tons of cargo.")
    }

    fun detachStage(){
        if(stages > 1) {
            stages--
            println("$name\'s stage detached.")
        } else println("$name has no more detachable stages.")
    }
}