package com.github.ked4ma.competitive.atcoder.abc385

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, SX, SY) = nextIntList()
    val houses = times(N) {
        val (X, Y) = nextLongList()
        X to Y
    }
    val xGroup = houses.groupBy(
        keySelector = { it.first },
        valueTransform = { it.second }
    ).mapValues { sortedSetOf<Long>().apply { addAll(it.value) } }
    val yGroup = houses.groupBy(
        keySelector = { it.second },
        valueTransform = { it.first }
    ).mapValues { sortedSetOf<Long>().apply { addAll(it.value) } }

    var x = SX.toLong()
    var y = SY.toLong()
    var ans = 0
    repeat(M) {
        val (D, C) = nextList().let { (D, C) -> D[0] to C.toLong() }
        val (dx, dy) = when (D) {
            'U' -> 0L to C
            'D' -> 0L to -C
            'L' -> -C to 0L
            'R' -> C to 0L
            else -> throw RuntimeException("unknown")
        }
        when (D) {
            'U', 'D' -> {
                if (x in xGroup) {
                    val sortedSet = xGroup.getValue(x)
                    val (l, r) = listOf(y, y + dy).sorted()
                    _debug_println("$l .. $r")
                    while (true) {
                        val yy = sortedSet.ceiling(l)
                        if (yy == null || yy > r) break
                        ans++
                        sortedSet.remove(yy)
                        yGroup.getValue(yy).remove(x)
                    }
                    _debug_println(sortedSet)
                }
            }

            'L', 'R' -> {
                if (y in yGroup) {
                    val sortedSet = yGroup.getValue(y)
                    val (l, r) = listOf(x, x + dx).sorted()
                    _debug_println("$l .. $r")
                    while (true) {
                        val xx = sortedSet.ceiling(l)
                        if (xx == null || xx > r) break
                        ans++
                        sortedSet.remove(xx)
                        xGroup.getValue(xx).remove(y)
                    }
                    _debug_println(sortedSet)
                }
            }
        }
        x += dx
        y += dy
    }
    println("$x $y $ans")
}
