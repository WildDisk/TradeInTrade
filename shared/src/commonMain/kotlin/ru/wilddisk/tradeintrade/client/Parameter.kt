package ru.wilddisk.tradeintrade.client

/**
 * Параметры в url
 * @property origin клиент ktor
 */
class Parameter(private val origin: Client) {
    /**
     * Параметр
     * @param key ключ параметра
     * @param value значение параметра
     */
    fun with(key: String, value: String): Parameter = Parameter(
        Client(this.origin.ktor, URLParameter(this.origin.url).add(key, value))
    )
    /**
     * Построение клиента с параметрами
     */
    fun build(): Client = this.origin
}