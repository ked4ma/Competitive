package com.github.ked4ma.competitive.atcoder.abc443

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.fenwick.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val (N, C) = nextIntList()
    val S = times(N) { nextCharArray() }
    val fts = sizedArray(N) { FenwickTree(N) }
    for (i in 0 until N) {
        for (j in 0 until N) {
            if (S[i][j] == '#') fts[j].add(i, 1)
        }
    }
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.add(N - 1 to C - 1)
    val vis = sized2DIntArray(N, N)
    vis[N - 1][C - 1] = 1
    while (queue.isNotEmpty()) {
        val (r, c) = queue.removeFirst()
        if (r == 0) continue
        val nr = r - 1
        for (nc in max(c - 1, 0)..min(c + 1, N - 1)) {
            if (vis[nr][nc] > 0) continue
            if (S[nr][nc] == '#') {
                if (fts[nc].sum(nr, N) > 1) {
                    vis[nr][nc] = 2
                    continue
                }
                fts[nc].add(nr, -1)
            }
            vis[nr][nc] = 1
            queue.add(nr to nc)
        }
    }
    _debug_println(vis[0])
    val sb = StringBuilder()
    for (i in 0 until N) {
        if (vis[0][i] == 1) {
            sb.append(1)
        } else {
            sb.append(0)
        }
    }
    println(sb.toString())
}
