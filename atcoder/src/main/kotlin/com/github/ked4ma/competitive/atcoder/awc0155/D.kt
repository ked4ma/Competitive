package com.github.ked4ma.competitive.atcoder.awc0155

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.cumlative.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val A = nextLongList()
    val aCum = A.cumulativeSum()
    var ans = 0L
    var left = -LONG_INF
    for (i in K until N - K + 1) {
        ans = max(ans, left + aCum[i + K] - aCum[i])
        left = max(left, aCum[i] - aCum[i - K])
    }
    println(ans)
}
// fun main() {
//     val (N, K) = nextIntList()
//     val A = nextLongList()
//     val aCum = A.cumulativeSum()
//     val segTree = SegmentTree.RUQ_RMQ(N - K + 1)
//     for (i in 0 until N - K + 1) {
//         segTree.set(i, aCum[i + K] - aCum[i])
//     }
//     var ans = 0L
//     for (i in 0 until N - K - K) {
//         ans = max(ans, segTree.query(i, i + 1) + segTree.query(i + K + 1, N - K + 1))
//     }
//     println(ans)
// }
