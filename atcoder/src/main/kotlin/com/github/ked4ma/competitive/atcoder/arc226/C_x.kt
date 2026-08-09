package com.github.ked4ma.competitive.atcoder.arc226

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    var (H, W) = nextIntList()
    val ans = mutableListOf<String>()
    if (H % 2 == 1 && W % 2 == 1) {
        while (H < W) {
            for (i in 1 until H step 2) {
                ans.add("$i ${W - 1} 1")
            }
            W -= 2
        }
        while (H > W) {
            for (j in 1 until W step 2) {
                ans.add("${H - 1} $j 1")
            }
            H -= 2
        }
        var r = 1
        var c = 1
        while (r < H) {
            ans.add("$r $c ${H - r}")
            for (j in c + 1 until H - 1 step 2) {
                ans.add("$r $j 1")
            }
            for (i in r + 2 until H step 2) {
                ans.add("$i $c 1")
            }
            for (i in r + 1 until H - 1 step 2) {
                ans.add("$i ${W - 1} 1")
            }
            for (j in c + 2 until W step 2) {
                ans.add("${H - 1} $j 1")
            }

            r += 2
            c += 2
            H -= 2
            W -= 2
        }
    } else {
        for (i in 1 until H step 2) {
            for (j in 1 until W step 2) {
                ans.add("$i $j 1")
            }
        }
    }
    println(ans.size)
    println(ans.joinToString("\n"))
}
