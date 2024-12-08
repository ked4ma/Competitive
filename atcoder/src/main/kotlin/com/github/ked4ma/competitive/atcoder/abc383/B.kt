package com.github.ked4ma.competitive.atcoder.abc383

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.abs
import kotlin.math.max


// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W, D) = nextIntList()
    val S = times(H) { nextCharArray() }

    var ans = 0
    for (h in range(H)) {
        for (w in range(W)) {
            if (S[h][w] == '#') continue
            for (h2 in h until H) {
                for (w2 in w until W) {
                    if (h == h2 && w == w2) continue
                    if (S[h2][w2] == '#') continue
                    var cnt = 0
                    for (h3 in range(H)) {
                        for (w3 in range(W)) {
                            if (S[h3][w3] == '#') continue
                            if (abs(h3 - h) + abs(w3 - w) <= D || abs(h3 - h2) + abs(w3 - w2) <= D) {
                                cnt++
                            }
                        }
                    }
                    ans = max(ans, cnt)
                }
            }
        }
    }
    println(ans)
}
