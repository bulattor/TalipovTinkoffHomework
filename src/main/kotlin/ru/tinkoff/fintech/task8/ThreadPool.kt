package ru.tinkoff.fintech.task8

import java.util.concurrent.Executor
import java.util.concurrent.LinkedBlockingQueue

class ThreadPool(threadCount : Int) : Executor {
    var queue = LinkedBlockingQueue<Runnable>()
    private var threads = listOf<WorkerThread>()
    private val obj = Object()

    init {
        if ((threadCount < 9) and (threadCount > 0)) {
            for (i in 0..threadCount) {
                val thread = WorkerThread(queue, obj)
                thread.start()
                threads.plus(thread)
            }
        } else throw (Exception("Threads count is unavailable. Must be in range (1 - 8)"))
    }

    override fun execute(command: Runnable) {
        queue.put(command)
        synchronized(obj) {
            obj.notify()
        }
    }

    fun shutdown() {
        threads.forEach {
            it.interrupt()
        }
        synchronized(obj) {
            obj.notifyAll()
        }
    }
}