package com.github.ked4ma.competitive.atcoder.abc464

import com.github.ked4ma.competitive.common.array.char.d2.*
import com.github.ked4ma.competitive.common.array.char.output.*
import com.github.ked4ma.competitive.common.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W, Q) = nextIntList()
    val arr = sized2DCharArray(H, W, '.')

    data class D(val i: Int, val r: Int, val c: Int, val x: Char)

    val queue = PriorityQueue<D>(compareByDescending { it.i })
    queue.offer(D(-1, H - 1, W - 1, 'A'))
    repeat(Q) { i ->
        val (R, C, X) = nextList().let { (R, C, X) -> Triple(R.toInt(), C.toInt(), X[0]) }
        queue.offer(D(i, R - 1, C - 1, X))
    }

    val dirs = listOf(
        -1 to 0,
        0 to -1,
    )
    while (queue.isNotEmpty()) {
        val (i, r, c, x) = queue.poll()
        if (arr[r][c] != '.') continue
        arr[r][c] = x
        for ((dr, dc) in dirs) {
            val nr = r + dr
            val nc = c + dc
            if (nr !in 0 until H || nc !in 0 until W || arr[nr][nc] != '.') continue
            queue.offer(D(i, nr, nc, x))
        }
    }
    arr.println()
}
