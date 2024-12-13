package ru.wilddisk.tradeintrade

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
    routing {
        get("json/kotlinx-serialization") {
            call.respond(mapOf("hello" to "world"))
        }
        get("user") {
            call.respond(User("Вася", 23))
        }
    }
}

@Serializable
data class User(val name: String, val age: Int)