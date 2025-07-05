package com.github.ked4ma.competitive.test.client

import com.github.ked4ma.competitive.test.Platform
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.Cookie
import io.ktor.http.Url
import org.jsoup.Jsoup

class CodeforcesClient : BaseTaskClient(Platform.CODEFORCES) {
    override suspend fun login(username: String, password: String, rawCookieString: String?) {
        // ("Not yet implemented")
    }

    override suspend fun sessionCookie(): Cookie? {
        // ("Not yet implemented")
        return null
    }

    override suspend fun getTaskUrl(contest: String, task: String): Url {
        return Url("$baseUrl/contest/$contest/problem/$task")
    }

    override suspend fun retrieveExamples(url: Url): List<Pair<String, String>> {
        val html = client.get(url).bodyAsText()
        return Jsoup.parse(html)
            .select(".sample-tests .sample-test > div pre")
            .windowed(2, 2)
            .map { (input, output) ->
                input.select("div").joinToString("\n") { it.text() } to output.text()
            }.apply { println(this) }
    }
}
