package dev.kissed.blankkmp.util.performance

import dev.kissed.blankkmp.util.concurrency.createSingleThreadDispatcher
import dev.kissed.blankkmp.util.logging.DebugLog
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.time.Duration.Companion.milliseconds

class MainThreadBusyWatchdog {

    private val watchdogDispatcher: CoroutineDispatcher =
        Dispatchers.createSingleThreadDispatcher("anr_watchdog")

    fun CoroutineScope.startWatching() {
        launch(watchdogDispatcher + SupervisorJob()) {
            var failedPings = 0

            while (isActive) {
                val pingJob = launch(Dispatchers.Main) { }
                val ping = withTimeoutOrNull(PING_TIMEOUT) {
                    pingJob.join()
                    true
                } ?: false

                if (ping) {
                    failedPings = 0
                } else {
                    failedPings++
                }

                if (failedPings > 5) {
                    DebugLog.d("ANR detected")
                }

                delay(PING_TIMEOUT)
            }
        }
    }

    companion object {
        private val PING_TIMEOUT = (16 * 10).milliseconds // 100 frames
    }
}