package dev.kissed.blankkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform