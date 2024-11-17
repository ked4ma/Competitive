package com.github.ked4ma.competitive.test.client

import com.github.ked4ma.competitive.test.Platform
import io.ktor.client.request.forms.submitForm
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import io.ktor.http.Url
import io.ktor.http.parameters
import org.jsoup.Jsoup

class AtCoderClient : BaseTaskClient(Platform.ATCODER) {

    override suspend fun login(username: String, password: String) {
        val url = "$baseUrl/login"
        val loginPage = client.get(url)
        val csrfToken = Jsoup.parse(loginPage.bodyAsText())
            .select("input[name=\"csrf_token\"]")[0]
            .attr("value")

        client.submitForm(
            url,
            formParameters = parameters {
                append("csrf_token", csrfToken)
                append("username", username)
                append("password", password)
            }
        )

        saveSession(sessionCookie())
    }

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
        val exampleSelector = if (document.selectFirst(".lang-ja") == null) {
            // old contest (e.g. abc041) doesn't have element with 'lang-ja' class
            "#task-statement > section"
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

    override fun close() {
        client.close()
    }
}
