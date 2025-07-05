package com.github.ked4ma.competitive.test.client

import com.github.ked4ma.competitive.test.Platform
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.UserAgent
import io.ktor.client.plugins.cookies.AcceptAllCookiesStorage
import io.ktor.client.plugins.cookies.CookiesStorage
import io.ktor.client.plugins.cookies.HttpCookies
import io.ktor.client.plugins.cookies.addCookie
import io.ktor.http.Cookie
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.json.encodeToStream
import java.io.File

abstract class BaseTaskClient(private val platform: Platform) : TaskClient {
    protected val baseUrl = platform.baseUrl
    protected val cookiesStorage: CookiesStorage = AcceptAllCookiesStorage()
    protected val client = HttpClient(CIO) {
        val cookie = loadSession()
        if (cookie != null) {
            runBlocking {
                cookiesStorage.addCookie(platform.baseUrl, cookie)
            }
        }
        install(HttpCookies) {
            storage = cookiesStorage
        }
        install(UserAgent) {
            agent =
                "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36"
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    private fun loadSession(): Cookie? {
        println("[INFO] load session")
        val file = File("../session-${platform.name.lowercase()}.json")
        if (!file.exists()) return null
        val cookie = Json.decodeFromStream<Cookie>(file.inputStream())
        return if ((cookie.expires?.timestamp ?: 0) - 6000_000 < System.currentTimeMillis()) {
            null
        } else {
            cookie
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    protected fun saveSession(cookie: Cookie?) {
        if (cookie == null) return
        println("[INFO] save session data for next run")
        val file = File("../session-${platform.name.lowercase()}.json")
        Json.encodeToStream(cookie, file.outputStream())
    }

    override fun close() {
        client.close()
    }
}
