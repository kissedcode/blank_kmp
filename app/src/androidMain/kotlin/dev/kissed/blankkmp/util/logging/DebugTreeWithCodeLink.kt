package dev.kissed.blankkmp.util.logging

import android.util.Log
import io.github.aakira.napier.Antilog
import io.github.aakira.napier.Napier

class DebugTreeWithCodeLink : Antilog() {

//    private val codeLink = ThreadLocal<String?>() // TODO: use this

    override fun performLog(
        priority: Napier.Level,
        tag: String?,
        throwable: Throwable?, // TODO: use this one
        message: String?
    ) {
//        var codeLinkStr: String?
//        codeLinkStr = codeLink.get()
//        if (codeLinkStr == null) {
//        codeLinkStr = createTagAndCodeLink(Throwable().stackTrace)
//        } else {
//            codeLink.set(null)
//        }

        val (autoTag, codeLink) = createTagAndCodeLink(Throwable().stackTrace) // TODO: find out what is better, Thread.currentThread().stackTrace)

        val resultTag = tag ?: autoTag
        val resultMessage = "($codeLink) $message"

        Log.println(priority.toAndroidLogLevel(), resultTag, resultMessage)
    }


    private fun Napier.Level.toAndroidLogLevel(): Int {
        return when (this) {
            Napier.Level.VERBOSE -> Log.VERBOSE
            Napier.Level.DEBUG -> Log.DEBUG
            Napier.Level.INFO -> Log.INFO
            Napier.Level.WARNING -> Log.WARN
            Napier.Level.ERROR -> Log.ERROR
            Napier.Level.ASSERT -> Log.ASSERT
        }
    }

    private fun createTagAndCodeLink(stackTrace: Array<StackTraceElement>): Pair<String?, String> {
        check(stackTrace.size > CALL_STACK_INDEX) { "Synthetic stacktrace didn't have enough elements: are you using proguard?" }

        val stackTraceElement = stackTrace[CALL_STACK_INDEX]
        val tag = stackTraceElement.className
            ?.let { it.split(".").lastOrNull() }

        val codeLink = stackTraceElement.lineNumber
            .takeIf { it > 0 }
            ?.let { line ->
                "${stackTraceElement.fileName}:$line"
            } ?: ""
        return tag to codeLink
    }

    companion object {
        private const val CALL_STACK_INDEX = 7
    }
}