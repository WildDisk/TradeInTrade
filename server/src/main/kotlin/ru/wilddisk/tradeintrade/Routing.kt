package ru.wilddisk.tradeintrade

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        helloWorld()
    }
}

fun Route.helloWorld() {
    get {
        call.respondText("Hello World!")
    }
}