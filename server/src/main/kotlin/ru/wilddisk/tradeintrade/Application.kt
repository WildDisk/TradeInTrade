package ru.wilddisk.tradeintrade

import io.ktor.server.application.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)
//    embeddedServer(Netty, port = SERVER_PORT, host = "0.0.0.0", module = Application::module)
//        .start(wait = true)
//}

@Suppress("unused")
fun Application.module() {
    configureRouting()
    configureSerialization()
    configureHTTP()
    configureSockets()
}