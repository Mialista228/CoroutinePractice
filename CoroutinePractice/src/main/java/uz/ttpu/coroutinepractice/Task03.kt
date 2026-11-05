package uz.ttpu.coroutinepractice

import kotlinx.coroutines.*

suspend fun loadUser() {
    delay(100)
    println("Step 1: User loaded")
    checkPassword()
}

suspend fun checkPassword() {
    delay(100)
    println("Step 2: Password checked")
    openProfile()
}

suspend fun openProfile() {
    delay(100)
    println("Step 3: Profile opened")
}

suspend fun Task03() {
    loadUser()
}

// OUTPUT:
// Step 1: User loaded
// Step 2: Password checked
// Step 3: Profile opened

// EXPLANATION
// suspend functions pause execution without blocking the thread,
// but sequential calls within a coroutine still execute step-by-step in order.