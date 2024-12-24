package dev.kissed.blankkmp

import android.app.Application
import dev.kissed.blankkmp.util.performance.MainThreadBusyWatchdog
import io.github.aakira.napier.Antilog
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class DebugAntilogWithThread : Antilog() {

    private val debugAntilog = DebugAntilog()

    override fun performLog(
        priority: Napier.Level,
        tag: String?,
        throwable: Throwable?,
        message: String?
    ) {
        debugAntilog.log(priority, tag, throwable, "[${Thread.currentThread().name}]:$message")
    }
}

class AppApplication : Application() {

    private val appScope: CoroutineScope = GlobalScope

    override fun onCreate() {
        super.onCreate()
        Napier.base(DebugAntilogWithThread())

        startMainThreadWatchdog()

        appScope.launch(Dispatchers.Main) {
            while (isActive) {
                delay(3000)
                Napier.d("agon: main start sleeping")
                Thread.sleep(3000)
                Napier.d("agon: main awake!")
            }
        }
    }

    private fun startMainThreadWatchdog() {
        val mainThreadBusyWatchdog = MainThreadBusyWatchdog()
        with(mainThreadBusyWatchdog) {
            appScope.startWatching()
        }
    }
}