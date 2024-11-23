package com.github.ked4ma.competitive.test.client

import com.github.ked4ma.competitive.test.Platform
import io.ktor.http.Cookie
import io.ktor.http.Url

interface TaskClient: AutoCloseable {
    suspend fun login(username: String, password: String)
    suspend fun sessionCookie(): Cookie?
    suspend fun getTaskUrl(contest: String, task: String): Url
    suspend fun retrieveExamples(url: Url): List<Pair<String, String>>

    companion object {
        fun instanceOf(platform: Platform) = when (platform) {
            Platform.ATCODER -> AtCoderClient()
            Platform.CODEFORCES -> CodeforcesClient()
        }
    }
}