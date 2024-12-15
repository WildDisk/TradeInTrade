package ru.wilddisk.tradeintrade.client

/**
 * Путь до конечной точки обращения
 * @property origin клиент ktor
 */
class Path(private val origin: Client) {
    /**
     * URI до ендпоинта
     * @param uri
     */
    fun with(uri: String): Path = Path(Client(this.origin.ktor, SlashCutURI(this.origin.url).cut(uri)))
    /**
     * Параметры в URL
     */
    fun withParam(): Parameter = Parameter(Client(this.origin.ktor, this.origin.url + "?"))
    /**
     * Построение клиента с конечным URL
     */
    fun build(): Client = this.origin
}