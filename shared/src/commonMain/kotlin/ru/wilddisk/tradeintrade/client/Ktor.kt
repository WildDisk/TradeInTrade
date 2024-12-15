package ru.wilddisk.tradeintrade.client

import io.ktor.client.*
import io.ktor.client.engine.*

interface Ktor {
    /**
     * Конфигурирование клиента Ktor
     */
    class Configure(val client: HttpClient) {
        constructor(engineFactory: HttpClientEngineFactory<*>) : this(HttpClient(engineFactory))
        constructor(engine: HttpClientEngine) : this(HttpClient(engine))
    }
}
/**
 * Создание клиента и добавление
 */
fun HttpClient.host(host: String): Client = Client(Ktor.Configure(this), host)