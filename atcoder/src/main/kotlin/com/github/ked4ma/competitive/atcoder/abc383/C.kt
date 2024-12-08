package com.github.ked4ma.competitive.atcoder.abc383

import com.github.ked4ma.competitive.common.array.boolean.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W, D) = nextIntList()
    val S = times(H) { nextCharArray() }
    var ans = 0
    val arr = sized2DBooleanArray(H, W, false)
    val queue = PriorityQueue<Triple<Int, Int, Int>>(compareByDescending { it.third })
    for (h in range(H)) {
        for (w in range(W)) {
            if (S[h][w] != 'H') continue
            arr[h][w] = true
            queue.offer(Triple(h, w, D))
            ans++
        }
    }
    val dirs = listOf(
        1 to 0,
        -1 to 0,
        0 to 1,
        0 to -1,
    )
    while (queue.isNotEmpty()) {
        val (h, w, d) = queue.poll()
        for ((dh, dw) in dirs) {
            val nh = h + dh
            val nw = w + dw
            if (d == 0 || nh !in range(H) || nw !in range(W) || arr[nh][nw] || S[nh][nw] == '#') continue
            arr[nh][nw] = true
            queue.offer(Triple(nh, nw, d - 1))
            ans++
        }
    }
    println(ans)
}
