package uz.ttpu.coroutinepractice

import kotlinx.coroutines.*

fun main() = runBlocking {
    val parent = launch {
        launch {
            try { delay(1000) } finally { println("child 1 cancelled") }
        }
        launch {
            try { delay(1000) } finally { println("child 2 cancelled") }
        }
    }
    delay(100)
    println("cancelling parent")
    parent.cancelAndJoin()
    println("done")
}

// OUTPUT:
// parent started two children
//cancelling parent
//child 1 cancelled
//child 2 cancelled
//done

// EXPLANATION
// Cancellation in structured concurrency propagates downwards:
// cancelling a parent job automatically cancels all of its children.