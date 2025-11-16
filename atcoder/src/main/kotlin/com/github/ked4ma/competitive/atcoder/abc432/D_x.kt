package com.github.ked4ma.competitive.atcoder.abc432

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.unionfind.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, X, Y) = nextIntList()
    val queue = ArrayDeque<Rec>()
    queue.add(Rec(0, X.toLong() - 1, 0, Y.toLong() - 1))
    repeat(N) {
        val (C, A, B) = nextList().let { (C, A, B) -> Triple(C[0], A.toLong(), B.toLong()) }
        val size = queue.size
        repeat(size) {
            val rec = queue.removeFirst()
            when (C) {
                'X' -> {
                    if (rec.r < A) {
                        queue.addLast(rec.copy(t = rec.t - B, b = rec.b - B))
                    } else if (A <= rec.l) {
                        queue.addLast(rec.copy(t = rec.t + B, b = rec.b + B))
                    } else {
                        queue.addLast(rec.copy(r = A - 1, t = rec.t - B, b = rec.b - B))
                        queue.addLast(rec.copy(l = A, t = rec.t + B, b = rec.b + B))
                    }
                }

                'Y' -> {
                    if (rec.t < A) {
                        queue.addLast(rec.copy(l = rec.l - B, r = rec.r - B))
                    } else if (A <= rec.b) {
                        queue.addLast(rec.copy(l = rec.l + B, r = rec.r + B))
                    } else {
                        queue.addLast(rec.copy(t = A - 1, l = rec.l - B, r = rec.r - B))
                        queue.addLast(rec.copy(b = A, l = rec.l + B, r = rec.r + B))
                    }
                }
            }
        }
        _debug_println(queue.toList())
    }

    val list = queue.toList()
    val uf = UnionFind(list.size)
    for (i in 0 until list.size) {
        for (j in i + 1 until list.size) {
            if (uf.same(i, j)) continue
            if (list[i].isTouch(list[j])) {
                uf.unite(i, j)
            }
        }
    }
    _debug_println(list)
    _debug_println(uf.roots)
    val cnt = mutableMapOf<Int, Long>().withDefault { _ -> 0 }
    for (i in 0 until list.size) {
        val root = uf.find(i)
        cnt[root] = cnt.getValue(root) + list[i].area()
    }
    println(uf.uniqueRoots.size)
    println(cnt.values.sorted().joinToString(" "))
}

private data class Rec(val l: Long, val r: Long, val b: Long, val t: Long) {
    fun isTouch(other: Rec): Boolean {
        return ((r + 1 == other.l || other.r + 1 == l) && (b in other.b..other.t || other.b in b..t)) ||
                ((t + 1 == other.b || other.t + 1 == b) && (l in other.l..other.r || other.l in l..r))
    }

    fun area() = (r - l + 1) * (t - b + 1)
}
