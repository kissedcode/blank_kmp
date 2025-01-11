package dev.kissed.blankkmp.util.logging

actual object DebugLog {
    actual fun d(message: String) {
        println("DebugLog: $message")
    }
}