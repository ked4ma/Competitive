package com.github.ked4ma.competitive.atcoder.abc400

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val S = times(H) { nextCharArray() }
    val (A, B, C, D) = nextIntList().map { it - 1 }
    val arr = sized2DIntArray(H, W, INT_INF)
//    val queue = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.third })
    val queue = ArrayDeque<Triple<Int, Int, Int>>()
    queue.add(Triple(A, B, 0))
    val dirs = listOf(
        0 to 1,
        0 to -1,
        1 to 0,
        -1 to 0,
    )
    while (queue.isNotEmpty()) {
//        val (h, w, c) = queue.poll()
        val (h, w, c) = queue.removeFirst()
        if (c >= arr[h][w]) continue
        arr[h][w] = c
        for ((dh, dw) in dirs) {
            val nh = h + dh
            val nw = w + dw
            if (nh !in range(H) || nw !in range(W)) continue
            if (S[nh][nw] == '.') {
//                queue.offer(Triple(nh, nw, c))
                queue.addFirst(Triple(nh, nw, c))
            } else {
//                queue.offer(Triple(nh, nw, c + 1))
                queue.addLast(Triple(nh, nw, c + 1))
                val nh2 = nh + dh
                val nw2 = nw + dw
                if (nh2 in range(H) && nw2 in range(W)) {
//                    queue.offer(Triple(nh2, nw2, c + 1))
                    queue.addLast(Triple(nh2, nw2, c + 1))
                }
            }
        }
    }
    println(arr[C][D])
    arr.forEach { _debug_println(it.joinToString(" ")) }
}
