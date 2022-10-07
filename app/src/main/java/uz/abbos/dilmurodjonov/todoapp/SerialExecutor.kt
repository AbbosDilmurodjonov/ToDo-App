package uz.abbos.dilmurodjonov.todoapp

import java.util.concurrent.Executor
import java.util.concurrent.Executors

class SerialExecutor : Executor {
    private val tasks = java.util.ArrayDeque<Runnable>()
    private val executor = Executors.newSingleThreadExecutor()
    private var active: Runnable? = null

    @Synchronized
    override fun execute(r: Runnable) {
        tasks.add(Runnable {
            try {
                r.run()
            } finally {
                scheduleNext()
            }
        })
        if (active == null) {
            scheduleNext()
        }
    }

    @Synchronized
    private fun scheduleNext() {
        if (tasks.poll().also { active = it } != null) {
            executor.execute(active)
        }
    }
}