package dev.kissed.blankkmp.util.concurrency

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual fun Dispatchers.createSingleThreadDispatcher(name: String): CoroutineDispatcher {
    return TODO()
}