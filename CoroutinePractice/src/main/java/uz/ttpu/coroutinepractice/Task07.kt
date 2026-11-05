package uz.ttpu.coroutinepractice

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("1")
    launch {
        println("2")
        delay(100)
        println("3")
    }
    println("4")
    delay(50)
    println("5")
}

// OUTPUT:
// 1
//4
//2
//5
//3

// EXPLANATION
// launch queues the new coroutine on the dispatcher.
// The outer body continues executing immediately (println("4")) until it reaches a suspension point (delay(50)),
// at which point the dispatcher turns execution over to the queued coroutine to print "2".