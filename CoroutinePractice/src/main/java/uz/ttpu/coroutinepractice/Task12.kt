package uz.ttpu.coroutinepractice

import kotlinx.coroutines.*

fun CoroutineScope.greetBackground(name: String) = launch {
    delay(100)
    println("Hello, $name")
}

suspend fun greetAll(names: List<String>) = coroutineScope {
    names.forEach { name ->
        launch {
            delay(100)
            println("Hello, $name")
        }
    }
}

fun main() = runBlocking {
    greetBackground("Alice")
    println("greetBackground returned at once")

    greetAll(listOf("Bob", "Charlie"))
    println("greetAll waited until finished")
}

// OUTPUT:
// greetBackground returned at once
//Hello, Alice
//Hello, Bob
//Hello, Charlie
//greetAll waited until finished
