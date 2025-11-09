package com.github.ked4ma.competitive.atcoder.abc431

import com.github.ked4ma.competitive.common.array.int.d3.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val (H, W) = nextIntList()
    val S = times(H) { nextCharArray() }
    val arr = sized3DIntArray(H, W, 4, INT_INF)
    val dirs = listOf(
        1 to 0, // v
        0 to 1, // >
        -1 to 0, // ^
        0 to -1, // <
    )

    data class D(val h: Int, val w: Int, val c: Int, val d: Int)

    val costMap = mapOf(
        'A' to mapOf(
            (0 to 2) to 0,
            (1 to 3) to 0,
            (2 to 0) to 0,
            (3 to 1) to 0,
        ).withDefault { _ -> 1 },
        'B' to mapOf(
            (0 to 3) to 0,
            (1 to 2) to 0,
            (2 to 1) to 0,
            (3 to 0) to 0,
        ).withDefault { _ -> 1 },
        'C' to mapOf(
            (0 to 1) to 0,
            (1 to 0) to 0,
            (2 to 3) to 0,
            (3 to 2) to 0,
        ).withDefault { _ -> 1 }
    )

    val queue = ArrayDeque<D>()
    queue.add(D(0, 0, 0, 3))
    while (queue.isNotEmpty()) {
        _debug_println(H == 2 && W == 2) { queue.first() }
        val (h, w, c, d) = queue.removeFirst()
        for (nd in 0 until 4) {
            val (dh, dw) = dirs[nd]
            val nh = h + dh
            val nw = w + dw
            val dc = costMap.getValue(S[h][w]).getValue(d to nd)
            if (arr[h][w][nd] <= c + dc) continue
            arr[h][w][nd] = c + dc
            if (nh !in 0 until H || nw !in 0 until W) continue
            if (dc == 0) {
                queue.addFirst(D(nh, nw, c + dc, (nd + 2) % 4))
            } else {
                queue.addLast(D(nh, nw, c + dc, (nd + 2) % 4))
            }
        }
    }
    println(arr[H - 1][W - 1][1])
    _debug_println(H == 2 && W == 2) { arr[0][0] }
    _debug_println(H == 2 && W == 2) { arr[0][1] }
    _debug_println(H == 2 && W == 2) { arr[1][0] }
    _debug_println(H == 2 && W == 2) { arr[1][1] }
}
