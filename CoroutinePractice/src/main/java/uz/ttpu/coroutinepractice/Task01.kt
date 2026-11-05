package uz.ttpu.coroutinepractice

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

fun Task01() = runBlocking {
    launch {
        delay(1000.milliseconds)
        println("Coffee ready")
    }
    println("Order created")
}

// OUTPUT:
// Order created
// Coffee ready

// EXPLANATION
// launch schedules the coroutine concurrently without blocking the execution of the surrounding code.
// Therefore, println("Order accepted") runs immediately, while the launched coroutine delays for 1 second before printing.