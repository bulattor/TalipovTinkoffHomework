package ru.tinkoff.fintech.task5


fun main(){
    val cards = listOf(
        GraphicsCard(
            "GV-N3090EAGLE OC-24GD",
            "GIGABYTE",
            "NVIDIA GeForce RTX 3090",
            320290.0,
            24
        ),
        GraphicsCard(
            "PA-RTX3080Ti GAMINGPRO 12GB",
            "Palit",
            "NVIDIA GeForce RTX 3080TI",
            189590.0,
            12
        ),
        GraphicsCard(
            "TUF-RTX3080TI-O12G-GAMING",
            "ASUS",
            "NVIDIA GeForce RTX 3080TI",
            207990.0,
            12
        ),
        GraphicsCard(
            "GV-N307TAORUS M-8GD",
            "GIGABYTE",
            "NVIDIA GeForce RTX 3070TI",
            125990.0,
            8
        ),
        GraphicsCard(
            "TUF-RTX3070TI-O8G-GAMING",
            "ASUS",
            "NVIDIA GeForce RTX 3070TI",
            130990.0,
            8
        ),
    )

    val service = GCListService()

    println(service.sortByPrice(cards).toList().toString()
        .replace(", ", "\n")
        .replace("[", "")
        .replace("]", "")
    )
    println()
    println(service.groupByBrand(cards).toList().toString()
        .replace(", ", "\n")
        .replace("(","")
        .replace(")","")
        .replace("[", "")
        .replace("]", "")
    )
    println()
    val tiList = service.countByPredicate(cards) { it.chipset.contains("TI") }
    println(
        tiList.first.toString() + "\n" + tiList.second.toString()
            .replace(", ", "\n")
            .replace("[", "")
            .replace("]", "")
                + "\n..."
    )
}