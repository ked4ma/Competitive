package com.github.ked4ma.competitive.atcoder.abc471

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val cmp = Comparator<String> { a, b ->
        if (a.length == b.length) {
            a.compareTo(b)
        } else {
            a.length - b.length
        }
    }
    val S = times(N) { next() }.sortedWith(cmp).asReversed()
    _debug_println(S)

    var ans = "0"
    fun update(l: Collection<String>) {
        val s2 = l.sortedWith { a, b -> (a + b).compareTo(b + a) }.asReversed()
        var now = s2.joinToString("")
        _debug_println(now)
        run {
            var i = 0
            while (i < now.length && now[i] == '0') i++
            now = now.substring(i, now.length)
        }
        if (cmp.compare(now, ans) > 0) ans = now
    }
    update(S.subList(0, K))
    run {
        var best = "0"
        var v = 0L
        for (i in K until N) {
            if (S[i].toLong() > v) {
                best = S[i]
                v = S[i].toLong()
            }
        }
        update(S.subList(0, K - 1) + best)
    }
    println(ans)
}
