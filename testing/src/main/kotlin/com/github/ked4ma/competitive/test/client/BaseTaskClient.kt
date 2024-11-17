package com.github.ked4ma.competitive.test.client

import com.github.ked4ma.competitive.test.Platform
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.cookies.ConstantCookiesStorage
import io.ktor.client.plugins.cookies.HttpCookies
import io.ktor.client.plugins.cookies.cookies
import io.ktor.http.Cookie
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.json.encodeToStream
import java.io.File

abstract class BaseTaskClient(private val platform: Platform) : TaskClient {
    protected val baseUrl = platform.baseUrl
    protected val client = HttpClient(CIO) {
        val cookie = loadSession()
        if (cookie == null) {
            install(HttpCookies)
        } else {
            install(HttpCookies) {
                storage = ConstantCookiesStorage(cookie)
            }
        }
    }

    override suspend fun sessionCookie() = client.cookies(baseUrl).firstOrNull { it.name == "REVEL_SESSION" }

    @OptIn(ExperimentalSerializationApi::class)
    private fun loadSession(): Cookie? {
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
        val file = File("../session-${platform.name.lowercase()}.json")
        Json.encodeToStream(cookie, file.outputStream())
    }
}