package dev.kissed.blankkmp.util.concurrency

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

expect fun Dispatchers.createSingleThreadDispatcher(name: String): CoroutineDispatcher