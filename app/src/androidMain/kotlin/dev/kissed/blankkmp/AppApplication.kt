package dev.kissed.blankkmp

import android.app.Application
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        
        Napier.base(DebugAntilog())
    }
}