package com.github.ked4ma.competitive.atcoder.abc386

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.abs

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val K = nextInt()
    val S = nextCharArray()
    val T = nextCharArray()
    val sizeDiff = abs(S.size - T.size)
    when {
        sizeDiff > 1 -> {
            println("No")
        }

        sizeDiff == 1 -> {
            val (s, t) = if (S.size > T.size) T to S else S to T
            var i = 0
            var j = 0
            while (i < s.size) {
                if (s[i] != t[j]) {
                    j++
                    if (j - i > 1) {
                        println("No")
                        return
                    }
                }
                i++
                j++
            }
            println("Yes")
        }

        else -> { // 0
            var cnt = 0
            for (i in range(S.size)) {
                if (S[i] != T[i]) cnt++
            }
            println(if (cnt > 1) "No" else "Yes")
        }
    }
}
