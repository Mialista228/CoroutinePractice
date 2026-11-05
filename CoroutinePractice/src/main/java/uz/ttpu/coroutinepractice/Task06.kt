package uz.ttpu.coroutinepractice

import kotlinx.coroutines.*

fun main() = runBlocking {
    repeat(10) { i ->
        launch {
            println("download $i started on ${Thread.currentThread().name}")
            delay(500)
            println("download $i finished")
        }
    }
}

// OUTPUT
// download 0 started on main
//download 1 started on main
//download 2 started on main
//download 3 started on main
//download 4 started on main
//download 5 started on main
//download 6 started on main
//download 7 started on main
//download 8 started on main
//download 9 started on main
//download 0 finished
//download 1 finished
//download 2 finished
//download 3 finished
//download 4 finished
//download 5 finished
//download 6 finished
//download 7 finished
//download 8 finished
//download 9 finished

// EXPLANATION
// This is concurrency, not parallelism.
// Multiple tasks make progress by yielding execution on a single thread,
// but they do not execute simultaneously at the exact same physical instant (which requires multiple CPU threads/cores).