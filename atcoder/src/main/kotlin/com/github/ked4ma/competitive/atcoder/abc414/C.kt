package com.github.ked4ma.competitive.atcoder.abc414

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val A = nextInt()
    val N = nextLong()
    var ans = 0L
    fun check(n: Long): Boolean {
        val sb = StringBuilder()
        var m = n
        while (m >= A) {
            sb.append(m % A)
            m /= A
        }
        sb.append(m)
        val s = sb.toString()
        return s == s.reversed()
    }

    fun make(s: String) {
        if (s.length > 12) return
        if (s.isNotEmpty() && s.first() != '0' && s.last() != '0') {
            val n = s.toLong()
            if (n > N) return
            if (s == s.reversed() && check(n)) ans += n
        }
        for (i in '0'..'9') {
            make("$i$s$i")
        }
    }

    make("")
    for (i in '0'..'9') {
        make(i.toString())
    }
    println(ans)
}
