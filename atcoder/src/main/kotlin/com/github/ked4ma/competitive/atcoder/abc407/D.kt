package com.github.ked4ma.competitive.atcoder.abc407

import com.github.ked4ma.competitive.common.array.boolean.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val A = times(H) { nextLongList() }
    var ans = A.fold(0L) { acc, a -> acc xor a.fold(0L) { acc2, b -> acc2 xor b } }
    _debug_println(ans)
    val vis = sized2DBooleanArray(H, W, false)
    fun dfs(h: Int, w: Int, cur: Long) {
        if (h == H - 1 && w == W - 1) return
        val nw = (w + 1) % W
        val nh = h + (w + 1) / W
        // not put here
        dfs(nh, nw, cur)
        if (vis[h][w]) {
            return
        }
        vis[h][w] = true
        var next = cur xor A[h][w]
        // ■■
        if (w + 1 < W && !vis[h][w + 1]) {
            vis[h][w + 1] = true
            next = next xor A[h][w + 1]
            ans = max(ans, next)
            dfs(nh, nw, next)
            next = next xor A[h][w + 1]
            vis[h][w + 1] = false
        }
        // ■
        // ■
        if (h + 1 < H && !vis[h + 1][w]) {
            vis[h + 1][w] = true
            next = next xor A[h + 1][w]
            ans = max(ans, next)
            dfs(nh, nw, next)
            next = next xor A[h + 1][w]
            vis[h + 1][w] = false
        }
        vis[h][w] = false
    }
    dfs(0, 0, ans)
    println(ans)
}
