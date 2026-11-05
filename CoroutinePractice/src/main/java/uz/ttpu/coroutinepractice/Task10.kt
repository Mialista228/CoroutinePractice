package uz.ttpu.coroutinepractice

import kotlinx.coroutines.*

fun main() = runBlocking {
    coroutineScope {
        launch { delay(200); println("Avatar loaded") }
        launch { delay(100); println("Settings loaded") }
    }
    println("Profile ready")

    launch { delay(100); println("Background coroutine") }
    println("end of main")
}

// OUTPUT:
// Settings loaded
//Avatar loaded
//Profile ready
//end of main
//Background coroutine

// EXPLANATION
// coroutineScope suspends and waits for all internal child coroutines to finish before continuing.
// In contrast, launch starts a fire-and-forget coroutine asynchronously and moves directly to the next line ("end of main").