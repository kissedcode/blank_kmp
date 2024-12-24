package dev.kissed.blankkmp.util.concurrency

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext

@OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
actual fun Dispatchers.createSingleThreadDispatcher(name: String): CoroutineDispatcher {
    return newSingleThreadContext(name)
}