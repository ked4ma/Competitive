package com.github.ked4ma.competitive.atcoder.abc425

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val S = times(H) { nextCharArray() }
    val dirs = listOf(
        1 to 0,
        -1 to 0,
        0 to 1,
        0 to -1,
    )
    var ans = 0
    var targets = mutableSetOf<Pair<Int, Int>>()
    val cnt = sized2DIntArray(H, W, 0)
    for (h in 0 until H) {
        for (w in 0 until W) {
            if (S[h][w] == '#') {
                cnt[h][w] = 4
                ans++
                continue
            }
            var c = 0
            for ((dh, dw) in dirs) {
                val nh = h + dh
                val nw = w + dw
                if (nh in 0 until H && nw in 0 until W && S[nh][nw] == '#') c++
            }
            cnt[h][w] = c
            if (c == 1) targets.add(h to w)
        }
    }
    _debug_println(cnt)
    while (targets.isNotEmpty()) {
        val next = mutableSetOf<Pair<Int, Int>>()
        for ((h, w) in targets) {
            S[h][w] = '#'
            ans++
            for ((dh, dw) in dirs) {
                val nh = h + dh
                val nw = w + dw
                if (nh in 0 until H && nw in 0 until W) {
                    cnt[nh][nw]++
                    if (cnt[nh][nw] == 1) {
                        next.add(nh to nw)
                    } else {
                        next.remove(nh to nw)
                    }
                }
            }
        }
        targets = next
    }
    _debug_println(S.joinToString("\n") { it.joinToString("") })
    println(ans)
}
