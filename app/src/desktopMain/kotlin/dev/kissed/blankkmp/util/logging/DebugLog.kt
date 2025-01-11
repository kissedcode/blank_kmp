package dev.kissed.blankkmp.util.logging

import io.github.aakira.napier.Napier

actual object DebugLog {
    actual fun d(message: String) {
        Napier.d(message)
    }
}