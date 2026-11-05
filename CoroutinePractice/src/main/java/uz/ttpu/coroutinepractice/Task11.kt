package uz.ttpu.coroutinepractice

import kotlinx.coroutines.*

fun CoroutineScope.startCounter(name: String, limit: Int): Job {
    return launch {
        for (i in 1..limit) {
            println("$name: $i")
            delay(100)
        }
    }
}

fun main() = runBlocking {
    coroutineScope {
        startCounter("Counter A", 2)
        startCounter("Counter B", 3)
        println("launched")
    }
}

// OUTPUT:
// Counter A: 1
//Counter B: 1
//Counter A: 2
//Counter B: 2
//Counter B: 3

// EXPLANATION
// Why Receiver is Needed:
// Receiving CoroutineScope allows the extension function to use launch and attach the newly created coroutine to the caller's structured lifecycle scope.