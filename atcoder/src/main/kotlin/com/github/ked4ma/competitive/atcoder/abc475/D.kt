package com.github.ked4ma.competitive.atcoder.abc475

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.prime.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    fun f(s: CharArray): String {
        val map = mutableMapOf<Char, Char>()
        for ((i, element) in s.withIndex()) {
            val c = element
            if (c in map) {
                s[i] = map.getValue(c)
            } else {
                val x = 'a' + map.size
                map[c] = x
                s[i] = x
            }
        }
        return s.concatToString()
    }

    val S = nextCharArray()
    val primes = primes(10_000_000).filter { n ->
        n.toString().length == S.size
    }.associateBy { n ->
        f(n.toString().toCharArray())
    }
    val s = f(S)
    if (s in primes) {
        println(primes.getValue(s))
    } else {
        println(-1)
    }
}
