package com.github.ked4ma.competitive.atcoder.awc0152

import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q, M) = nextIntList()
    val A = nextLongList()
    val S = next()
    val list = mutableListOf<String>()
    val s = S.toCharArray()
    repeat(M) {
        val op = nextList()
        when (op[0]) {
            "1" -> {
                val i = op[1].toInt() - 1
                val c = op[2][0]
                s[i] = c
            }

            "2" -> {
                list.add(s.concatToString())
            }
        }
    }
    _debug_println(list)
    val vis = sizedBooleanArray(N)
    for (P in list) {
        var i = 0
        var ans = 0L
        vis.fill(false)
        for (p in P) {
            when (p) {
                'L' -> if (i - 1 >= 0) i--
                'R' -> if (i + 1 < N) i++

                'P' -> {
                    if (!vis[i]) {
                        vis[i] = true
                        ans += A[i]
                    }
                }

                'B' -> i = 0
            }
        }
        println(ans)
    }
}
