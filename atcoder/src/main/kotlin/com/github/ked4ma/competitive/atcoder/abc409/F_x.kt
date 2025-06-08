package com.github.ked4ma.competitive.atcoder.abc409

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.unionfind.*
import com.github.ked4ma.competitive.common.repeat.*
import java.util.*
import kotlin.math.abs

private data class Point(val x: Int, val y: Int)
private data class Data(val i: Int, val j: Int, val d: Int)

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val P = mutableListOf<Point>()
    val queue = PriorityQueue<Data> { a, b -> a.d.compareTo(b.d) }

    fun add(x: Int, y: Int) {
        val j = P.size
        for (i in range(P.size)) {
            val (xi, yi) = P[i]
            val dist = abs(x - xi) + abs(y - yi)
            queue.offer(Data(i, j, dist))
        }
        P.add(Point(x, y))
    }

    // init
    repeat(N) {
        val (x, y) = nextIntList()
        add(x, y)
    }

    val ans = StringJoiner("\n")
    val uf = UnionFind(N + Q)
    repeat(Q) {
        val q = nextIntList()
        when (q[0]) {
            1 -> add(q[1], q[2])
            2 -> {
                while (queue.isNotEmpty()) {
                    val (a, b, _) = queue.peek()
                    if (!uf.same(a, b)) break
                    queue.poll()
                }
                if (queue.isEmpty()) {
                    ans.add("-1")
                    return@repeat
                }
                val k = queue.peek().d
                ans.add(k.toString())
                while (queue.isNotEmpty() && queue.peek().d == k) {
                    val (a, b, _) = queue.poll()
                    uf.unite(a, b)
                }
            }

            3 -> ans.add(if (uf.same(q[1] - 1, q[2] - 1)) "Yes" else "No")
        }
    }
    println(ans)
}
