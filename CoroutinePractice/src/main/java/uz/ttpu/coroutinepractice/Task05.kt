package uz.ttpu.coroutinepractice

import kotlinx.coroutines.*

suspend fun getThreadName(): String {
    return Thread.currentThread().name
}

fun main() = runBlocking {
    println("Before: ${Thread.currentThread().name}")
    println("Inside: ${getThreadName()}")
}

// OUTPUT:
// Before: main
// Inside: main

// EXPLANATION
// Belief Status:
// Disproved. Marking a function suspend does not switch threads; it runs on the caller thread unless specified with a dispatcher (e.g., withContext(Dispatchers.IO)).
//
// Hidden Parameter:
// The compiler secretly adds a Continuation<T> parameter to every suspend function for Continuation-Passing Style (CPS).