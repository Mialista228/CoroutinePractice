package uz.ttpu.coroutinepractice

import kotlinx.coroutines.*

fun Task02() = runBlocking {
    launch { println("espresso start"); delay(300); println("espresso end") }
    launch { println("tea start"); delay(100); println("tea end") }
    launch { println("latte start"); delay(200); println("latte end") }
}

// OUTPUT with Delay:
// espresso start
// tea start
// latte start
// tea end
// latte end
// espresso end

// OUTPUT with Thread.sleep
// espresso start
// espresso end
// tea start
// tea end
// latte start
// latte end

// EXPLANATION
// delay suspends the coroutine, freeing the thread to run other coroutines concurrently,
// whereas Thread.sleep blocks the underlying thread completely,
// preventing any other coroutine on that thread from executing until it finishes.