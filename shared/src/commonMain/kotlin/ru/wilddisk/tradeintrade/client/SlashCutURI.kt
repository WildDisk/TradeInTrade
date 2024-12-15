package ru.wilddisk.tradeintrade.client

/**
 * Контроль / символов при добавлении в uri
 * @property url адрес ресурса
 */
class SlashCutURI(private val url: String) {
    /**
     * Удаляет / в uri если он был добавлен в url, дабы избежать получения строки с //
     */
    fun cut(uri: String): String = if (this.url.last() != "/".toCharArray()[0]) {
        this.url + "/" + uri.replace("/", "").trim()
    } else {
        this.url + uri.replace("/", "").trim()
    }
}