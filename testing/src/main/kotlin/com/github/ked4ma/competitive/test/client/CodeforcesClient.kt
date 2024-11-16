package com.github.ked4ma.competitive.test.client

import io.ktor.http.Cookie
import io.ktor.http.Url

class CodeforcesClient : TaskClient {
    override suspend fun login(username: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun sessionCookie(): Cookie? {
        TODO("Not yet implemented")
    }

    override suspend fun getTaskUrl(contest: String, task: String): Url {
        TODO("Not yet implemented")
    }

    override suspend fun retrieveExamples(url: Url): List<Pair<String, String>> {
        TODO("Not yet implemented")
    }

    override fun close() {
        TODO("Not yet implemented")
    }
}