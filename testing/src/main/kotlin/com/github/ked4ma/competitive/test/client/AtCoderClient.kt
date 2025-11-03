package com.github.ked4ma.competitive.test.client

import com.github.ked4ma.competitive.test.Platform
import io.ktor.client.plugins.cookies.addCookie
import io.ktor.client.plugins.cookies.cookies
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import io.ktor.http.Cookie
import io.ktor.http.CookieEncoding
import io.ktor.http.Url
import io.ktor.util.date.GMTDate
import org.jsoup.Jsoup

class AtCoderClient : BaseTaskClient(Platform.ATCODER) {
    override suspend fun login(username: String, password: String, rawCookieString: String?) {
        if (rawCookieString == null) {
            println("[WARN] Now, AtCoder introduce CAPTCHA(cloudflare).")
            println("[WARN] Due to this, please paste session string (REVEL_SESSION) from your browser into secret conf file instead.")
            throw IllegalArgumentException("raw cookie isn't set")
        }
        val data = rawCookieString.split("%00").map {
            it.split("%3A")
        }.filter { it.size == 2 }.associate { it[0] to it[1] }
        val cookie = Cookie(
            name = "REVEL_SESSION",
            value = rawCookieString,
            encoding = CookieEncoding.RAW,
            expires = GMTDate(data.getValue("_TS").toLong() * 1000),
            domain = "atcoder.jp",
            path = "/",
            secure = true,
            httpOnly = true
        )
        cookiesStorage.addCookie(baseUrl, cookie)
        // NOTE: codes when we could get session using jsoup
        // val url = "$baseUrl/login"
        // val loginPage = client.get(url)
        // val csrfToken = Jsoup.parse(loginPage.bodyAsText())
        //     .select("input[name=\"csrf_token\"]")[0]
        //     .attr("value")

        // val res = client.submitForm(
        //     url,
        //     formParameters = parameters {
        //         append("csrf_token", csrfToken)
        //         append("username", username)
        //         append("password", password)
        //     }
        // )
        saveSession(sessionCookie())
    }

    override suspend fun sessionCookie() = client.cookies(baseUrl).firstOrNull { it.name == "REVEL_SESSION" }

    override suspend fun getTaskUrl(contest: String, task: String): Url {
        val html = client.get { url("$baseUrl/contests/$contest/tasks?lang=ja") }.bodyAsText()
        return Jsoup.parse(html)
            .select("div.panel table.table tbody tr td:first-child a")
            .associate {
                it.text() to "$baseUrl${it.attr("href")}"
            }[task]?.let { Url(it) } ?: throw RuntimeException("$contest/$task is not found")
    }

    override suspend fun retrieveExamples(url: Url): List<Pair<String, String>> {
        val html = client.get(url).bodyAsText()
        val re = "[入出]力例\\s?\\d+".toRegex()
        val document = Jsoup.parse(html)
        val exampleSelector = if (document.selectFirst("#task-statement") != null) {
            // old contest (e.g. abc041) doesn't have element with 'lang-ja' class
            "#task-statement section"
        } else {
            ".lang-ja .part > section:nth-child(1)"
        }
        return document
            .select(exampleSelector)
            .filter { it ->
                it.selectFirst("h3")?.text()?.matches(re) ?: false
            }.mapNotNull {
                it.selectFirst("pre")?.text()?.split("\n")
                    ?.joinToString(separator = "\n", transform = String::trim)
            }.chunked(2) {
                it[0] to it[1]
            }
    }
}
