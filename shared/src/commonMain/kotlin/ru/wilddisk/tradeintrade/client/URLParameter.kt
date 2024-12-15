package ru.wilddisk.tradeintrade.client

/**
 * Контроль за параметрами в uri
 * @property url адрес ресурса
 */
class URLParameter(private val url: String) {
    /** Добавляет параметр в url
     * @param key ключ параметра
     * @param value значение параметра
     */
    fun add(key: String, value: String): String {
        return if (this.url.last() == "?".toCharArray()[0] || this.url.last() == "&".toCharArray()[0]) {
            this.url + "$key=$value"
        } else {
            this.url + "&$key=$value"
        }
    }
}