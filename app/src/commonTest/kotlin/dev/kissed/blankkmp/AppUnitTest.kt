package dev.kissed.blankkmp

import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.measureTime

class AppUnitTest {
    
    @Test
    fun simpleTest() {
        assertEquals(1, 1)
    }
    
    @Test
    fun simpleCoroutinesTest() = runTest {
        val counter = Counter()
        assertEquals(0, counter.value)
        
        val time = measureTime {
            counter.incrementWithDelay()
            delay(1000)
            assertEquals(1, counter.value)    
        }
        println("time: $time")
    }
}