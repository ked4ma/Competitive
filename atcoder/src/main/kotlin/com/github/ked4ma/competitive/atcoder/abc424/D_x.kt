package com.github.ked4ma.competitive.atcoder.abc424

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private val rect = listOf(
    0 to 0,
    0 to 1,
    1 to 0,
    1 to 1,
)

private fun solve() {
    val (H, W) = nextIntList()
    val S = times(H) { nextCharArray() }.toTypedArray()
    var ans = 9
    fun dfs(h: Int, w: Int, c: Int) {
        if (c >= ans) return
        var i = h
        var j = w
        while (i < H - 1) {
            val nj = (j + 1) % (W - 1)
            val ni = if (nj == 0) i + 1 else i
            if (rect.all { (dh, dw) -> S[i + dh][j + dw] == '#' }) {
                S[i + 1][j] = '.'
                dfs(ni, nj, c + 1)
                S[i + 1][j] = '#'
                S[i + 1][j + 1] = '.'
                dfs(ni, nj, c + 1)
                S[i + 1][j + 1] = '#'
                return
            }
            i = ni
            j = nj
        }
        ans = min(ans, c)
    }
    dfs(0, 0, 0)
    println(ans)
}
