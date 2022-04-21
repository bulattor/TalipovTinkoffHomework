package ru.tinkoff.fintech.task8

import java.util.concurrent.LinkedBlockingQueue

class WorkerThread(private val queue: LinkedBlockingQueue<Runnable>, private val obj: Object) : Thread() {
    override fun run () {
        while (!isInterrupted)
        {
            if(queue.isEmpty()) {
                synchronized(obj) {
                    obj.wait()
                }
            } else {
                queue.take().run()
            }
        }
    }
}