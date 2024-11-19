package dev.kissed.blankkmp

fun debugLog(msg: String) {
    println("[${Thread.currentThread().name}] $msg")
}