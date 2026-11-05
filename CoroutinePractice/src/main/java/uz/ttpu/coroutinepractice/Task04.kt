package uz.ttpu.coroutinepractice

import kotlin.coroutines.*

suspend fun loadUserFunction(){

}

suspend fun caller (){
    loadUserFunction()
}

// Compile Error:
// Suspend function 'loadUser' should be called only from a coroutine or another suspend function
//
// Fixes:
//
// Fix 1: Mark the caller function as suspend.
// suspend fun caller() { loadUser() }
//
// Fix 2: Wrap the call inside a coroutine builder like CoroutineScope(...).launch { loadUser() } or runBlocking { loadUser() }.
//
// Android UI Thread Rule:
//
// Never use runBlocking on the Android UI thread because it blocks the UI thread synchronously,
// causing the app to freeze or crash with an ANR (Application Not Responding).