package com.github.ked4ma.competitive.atcoder.problems

import com.github.ked4ma.competitive.common.input.default.nextIntList
import java.util.*

// make problems

// const val CONTEST = "past202004-open" // [_debug_]
// const val CONTEST = "past202107-open" // [_debug_] 7th

const val CONTEST = "abc308" // [_debug_]
const val TASK = "F" // [_debug_]

fun main() {
    val (N, M) = nextIntList()
    val P = nextIntList().sorted()
    val LD = nextIntList().zip(nextIntList()).sortedBy { it.first }

    var ans = 0L
    val queue = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.second })
    var i = 0
    for (p in P) {
        while (i < M && LD[i].first <= p) {
            queue.offer(LD[i])
            i++
        }
        ans += p
        if (queue.isNotEmpty()) {
            ans -= queue.poll().second
        }
    }
    println(ans)
}
