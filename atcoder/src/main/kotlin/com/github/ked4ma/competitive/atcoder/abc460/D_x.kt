package com.github.ked4ma.competitive.atcoder.abc460

import com.github.ked4ma.competitive.common.array.char.d2.*
import com.github.ked4ma.competitive.common.array.char.output.*
import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val S = times(H) { nextCharArray() }
    val s = sized2DCharArray(H, W, '.')
    for (h in 0 until H) {
        for (w in 0 until W) {
            if (S[h][w] == '.') continue
            for (dh in -1..1) {
                for (dw in -1..1) {
                    val nh = h + dh
                    val nw = w + dw
                    if (nh !in 0 until H || nw !in 0 until W || S[nh][nw] == '#') continue
                    s[nh][nw] = '#'
                }
            }
        }
    }

    val arr = sized2DIntArray(H, W, INT_INF)
    val queue = ArrayDeque<Pair<Int, Int>>()
    for (h in 0 until H) {
        for (w in 0 until W) {
            if (s[h][w] == '#') {
                arr[h][w] = 1
                queue.add(h to w)
            }
        }
    }
    while (queue.isNotEmpty()) {
        val (h, w) = queue.removeFirst()
        for (dh in -1..1) {
            for (dw in -1..1) {
                if (dh == 0 && dw == 0) continue
                val nh = h + dh
                val nw = w + dw
                if (nh !in 0 until H || nw !in 0 until W || arr[nh][nw] <= arr[h][w] + 1) continue
                arr[nh][nw] = arr[h][w] + 1
                queue.add(nh to nw)
            }
        }
    }

    val ans = sized2DCharArray(H, W, '.')
    for (h in 0 until H) {
        for (w in 0 until W) {
            if (arr[h][w] % 2 == 0) {
                ans[h][w] = '#'
            }
        }
    }
    ans.println()
}
