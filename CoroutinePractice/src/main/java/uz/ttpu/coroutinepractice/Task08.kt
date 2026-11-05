package uz.ttpu.coroutinepractice

import kotlinx.coroutines.*

fun main() = runBlocking {
    val parentJob = launch {
        launch {
            delay(200)
            println("child done")
        }
        println("parent body done")
    }
    parentJob.join()
    println("report completed")
}

// OUTPUT:
// parent body done
//child done
//report completed

// EXPLANATION
// A parent coroutine scope/job will not complete until all of its child coroutines have completed.