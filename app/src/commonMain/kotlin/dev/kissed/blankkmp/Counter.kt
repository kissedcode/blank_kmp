package dev.kissed.blankkmp

import kotlinx.coroutines.delay
import kotlin.concurrent.Volatile

class Counter {
    @Volatile
    var value: Int = 0
    
    suspend fun incrementWithDelay() {
        delay(1000)
        value++
    }
}