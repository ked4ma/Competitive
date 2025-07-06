package com.github.ked4ma.competitive.atcoder.abc413

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import java.util.*
import kotlin.math.abs

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        println(if (solve2()) "Yes" else "No")
    }
}

private fun solve2(): Boolean {
    val N = nextInt()
    val A = nextLongList().sortedBy { abs(it) }
    run {
        var ok = true
        for (i in range(N - 2)) {
            if (A[i] * A[i + 2] != A[i + 1] * A[i + 1]) {
                ok = false
                break
            }
        }
        if (ok) return true
    }
    if (abs(A.first()) == abs(A.last())) {
        var pos = 0
        var neg = 0
        for (a in A) {
            if (a > 0) {
                pos++
            } else {
                neg++
            }
        }
        if (abs(pos - neg) <= 1) return true
    }
    return false
}

private fun solve() {
    val N = nextInt()
    val A = nextLongList()
    val plus = PriorityQueue<Long>()
    val minus = PriorityQueue<Long>(Comparator.reverseOrder())
    A.forEach {
        if (it > 0) {
            plus.offer(it)
        } else {
            minus.offer(it)
        }
    }
    if (plus.isNotEmpty() && minus.isNotEmpty() && abs(plus.size - minus.size) > 1) {
        println("No")
        return
    }
    val A2 = if (plus.isEmpty() || minus.isEmpty()) {
        A.sorted()
    } else {
        buildList {
            var i = 0
            if (minus.size > plus.size) {
                i = 1
            } else if (minus.size == plus.size && abs(minus.peek()) < plus.peek()) {
                i = 1
            }
            while (plus.isNotEmpty() || minus.isNotEmpty()) {
                val pq = if (i == 0) plus else minus
                add(pq.poll())
                i = 1 - i
            }
        }
    }
    _debug_println(A2)

    for (i in 0 until N - 2) {
        val a1 = A2[i]
        val a2 = A2[i + 1]
        val a3 = A2[i + 2]
        _debug_println("$a1 $a2 $a3")
        if (a2 * a2 != a1 * a3) {
            println("No")
            return
        }
    }
    println("Yes")
}
