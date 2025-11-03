package com.github.ked4ma.competitive.atcoder.abc385

import com.github.ked4ma.competitive.common.array.boolean.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W, X, Y) = nextIntList()
    val S = times(H) { nextCharArray() }
    val T = nextCharArray()

    var x = X - 1
    var y = Y - 1
    val vis = sized2DBooleanArray(H, W, false)
    vis[x][y] = true
    var ans = 0
    if (S[x][y] == '@') ans++
    for (t in T) {
        val (dx, dy) = when (t) {
            'U' -> -1 to 0
            'D' -> 1 to 0
            'L' -> 0 to -1
            'R' -> 0 to 1
            else -> throw RuntimeException("unknown")
        }
        val nx = x + dx
        val ny = y + dy
        if (nx !in range(H) || ny !in range(W) || S[nx][ny] == '#') continue
        x = nx
        y = ny
        _debug_println("$x $y")
        if (vis[x][y]) continue
        vis[x][y] = true
        if (S[x][y] == '@') ans++
    }
    println("${x + 1} ${y + 1} $ans")
}
