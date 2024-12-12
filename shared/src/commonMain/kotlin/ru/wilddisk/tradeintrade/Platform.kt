package ru.wilddisk.tradeintrade

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform