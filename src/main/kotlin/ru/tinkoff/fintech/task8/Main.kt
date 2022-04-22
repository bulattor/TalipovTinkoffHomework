package ru.tinkoff.fintech.task8

import kotlin.math.sqrt


fun main(){
    val commands = listOf(
        Runnable {
            println("1")
        },
        Runnable {
            println("2")
        },
        Runnable {
            var x = 0;
            while (x < 100000)
            {
                sqrt(x.toDouble())
                x++
            }
            println("3")
        },
        Runnable {
            println("4")
        },
        Runnable {
            var x = 0;
            while (x < 10000)
            {
                sqrt(x.toDouble())
                x++
            }
            println("5")
        },
        Runnable {
            println("6")
        },
    )

    val pool = ThreadPool(4)
    commands.forEach { pool.execute(it) }

    pool.shutdown()
}