package com.github.ked4ma.competitive.atcoder.abc467

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextLongList().let { (N, M) -> N.toInt() to M }
    val A = nextLongList()
    val B = nextLongList()

    val p = mutableListOf<Long>()
    val q = mutableListOf<Long>()
    val xs = mutableListOf<Long>()

    fun f(x: Long) = (x % M + M) % M

    run {
        var c = 0L
        for (i in 0 until N) {
            if (i % 2 == 0) {
                p.add(f(A[i] - c))
            } else {
                q.add(f(c - A[i]))
            }
            if (i != N - 1) c = f(B[i] - c)
        }
        xs.addAll((p + q).sorted().distinct().filter { it != 0L })
    }

    var now = 0L
    val pc = mutableMapOf<Long, Long>().withDefault { 0 }
    val qc = mutableMapOf<Long, Long>().withDefault { 0 }
    for (c in p) {
        now += f(-c)
        pc[c] = pc.getValue(c) + 1
    }
    for (c in q) {
        now += f(c)
        qc[c] = qc.getValue(c) + 1
    }
    var ans = now

    var px = 0L
    for (x in xs) {
        now += M * qc.getValue(px)
        now += (p.size - q.size).toLong() * (x - px)
        px = x
        now -= M * pc.getValue(x)
        ans = min(ans, now)
    }

    println(ans)
}
