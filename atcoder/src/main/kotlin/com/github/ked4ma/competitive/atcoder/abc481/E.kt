package com.github.ked4ma.competitive.atcoder.abc481

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.vec.long.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val N = nextInt()
    val XY = times(N) {
        val (X, Y) = nextLongList()
        LongVec(X, Y)
    }.sortedWith({ a, b -> cmp(a, b) })
//    }.map {
//        var r = atan2(it.y.toDouble(), it.x.toDouble())
//        if (r < 0) r += 2 * PI
//        r to it
//    }.sortedBy { it.first }.map { it.second }
    XY.forEach { _debug_println(it) }

    if (N == 1) {
        println(1)
        return
    }

    var ans = 0
    var cnt = 0
    var j = 0
    for (i in 0 until N) {
        while (true) {
            if (i == j) {
                cnt++
            } else if (XY[i].cross(XY[j]) > 0) {
                cnt++
            } else {
                break
            }
            j = (j + 1) % N
            if (j == i) break
        }
        ans = max(ans, cnt)
        cnt--
    }
    println(ans)
}

private fun cmp(a: LongVec, b: LongVec): Int {
    // 半平面(上/下)を計算
    val ah = if (a.y < 0 || (a.y == 0L && a.x < 0)) 1 else 0
    val bh = if (b.y < 0 || (b.y == 0L && b.x < 0)) 1 else 0
    // 別々の平面であればその時点で比較
    if (ah != bh) return ah - bh
    // ↓同一半平面である場合に外積を利用する
    val c = a.cross(b)
    if (c == 0L) return 0
    return if (c > 0) -1 else 1
}
