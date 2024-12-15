import io.ktor.client.engine.mock.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.runBlocking
import ru.wilddisk.tradeintrade.client.Ktor
import ru.wilddisk.tradeintrade.client.host
import kotlin.test.Test
import kotlin.test.assertEquals

class HttpClientTest {
    private val client = Ktor.Configure(
        MockEngine { _ ->
            respond(content = ByteReadChannel(""))
        }
    ).client.host("http://localhost:8080")
    @Test
    fun `add url to client`() {
        assertEquals("http://localhost:8080", client.url)
    }
    @Test
    fun `add endpoint in path`() {
        assertEquals("http://localhost:8080/test", client.withPath().with("test").build().url)
    }
    @Test
    fun `add param in url`() {
        val url = client.withPath().with("test").withParam().with("id", "test").build().url
        assertEquals("http://localhost:8080/test?id=test", url)
    }
    @Test
    fun `url in get request`(): Unit = runBlocking {
        assertEquals(
            "http://localhost:8080/api/test?id=test",
            client.withPath().with("api").with("test")
                .withParam().with("id", "test").build()
                .method().get()
                .request.url.toString())
    }
    @Test
    fun `method get`(): Unit = runBlocking {
        assertEquals(
            HttpMethod(value = "GET"),
            client.withPath().with("api").with("test")
                .withParam().with("id", "test").build()
                .method().get()
                .request.method
        )
    }
    @Test
    fun `url in post request`(): Unit = runBlocking {
        assertEquals(
            "http://localhost:8080/api/test?id=test",
            client.withPath().with("api").with("test")
                .withParam().with("id", "test").build()
                .method().post {}
                .request.url.toString()
        )
    }
    @Test
    fun `method post`(): Unit = runBlocking {
        assertEquals(
            HttpMethod(value = "POST"),
            client.withPath().with("api").with("test")
                .withParam().with("id", "test").build()
                .method().post {}
                .request.method
        )
    }
    @Test
    fun `url in put request`(): Unit = runBlocking {
        assertEquals(
            "http://localhost:8080/api/test?id=test",
            client.withPath().with("api").with("test")
                .withParam().with("id", "test").build()
                .method().put {}
                .request.url.toString()
        )
    }
    @Test
    fun `method put`(): Unit = runBlocking {
        assertEquals(
            HttpMethod(value = "PUT"),
            client.withPath().with("api").with("test")
                .withParam().with("id", "test").build()
                .method().put {}
                .request.method
        )
    }
    @Test
    fun `url in delete request`(): Unit = runBlocking {
        assertEquals(
            "http://localhost:8080/api/test?id=test",
            client.withPath().with("api").with("test")
                .withParam().with("id", "test").build()
                .method().delete()
                .request.url.toString()
        )
    }
    @Test
    fun `method delete`(): Unit = runBlocking {
        assertEquals(
            HttpMethod(value = "DELETE"),
            client.withPath().with("api").with("test")
                .withParam().with("id", "test").build()
                .method().delete()
                .request.method
        )
    }
}