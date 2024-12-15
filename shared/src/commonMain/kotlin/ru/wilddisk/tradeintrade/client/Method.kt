package ru.wilddisk.tradeintrade.client

import io.ktor.client.request.*
import io.ktor.client.statement.*

/**
 * Набор методов
 * @property origin клиент ktor
 */
class Method(private val origin: Client) {
    /**
     * GET Request
     */
    suspend fun get(): HttpResponse = this.origin.ktor.client.get(this.origin.url)
    /**
     * POST Request
     * @param block requestBuilder добавленными content-type, body и так далее
     */
    suspend fun post(block: HttpRequestBuilder.() -> Unit): HttpResponse = this.origin.ktor.client.post(this.origin.url) { block() }
    /**
     * PUT Request
     * @param block requestBuilder добавленными content-type, body и так далее
     */
    suspend fun put(block: HttpRequestBuilder.() -> Unit): HttpResponse = this.origin.ktor.client.put(this.origin.url) { block() }
    /**
     * DELETE Request
     */
    suspend fun delete(): HttpResponse = this.origin.ktor.client.delete(this.origin.url)
}