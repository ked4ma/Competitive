package com.github.ked4ma.competitive.atcoder.abc444

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, D) = nextIntList()
    val A = nextLongList()
    val set = sortedSetOf(-LONG_INF, LONG_INF)
    var ans = 0L
    var l = 0
    for (r in 0 until N) {
        while (true) {
            // [1,2,.... (A[r]) it ...]
            val right = set.ceiling(A[r])!!
            val left = set.floor(A[r])!!
            if (right - A[r] >= D && A[r] - left >= D) break
            set.remove(A[l])
            l++
        }
        set.add(A[r])
        ans += r - l + 1
    }
    println(ans)
}

// fun main() {
//     val (N, D) = nextIntList()
//     val A = nextLongList()
//     var ans = 0L
//     var r = 0
//     val set = sortedSetOf(-LONG_INF, LONG_INF)
//     for (l in 0 until N) {
//         while (r < N) {
//             // it <= A[r]
//             var it = set.floor(A[r])!!
//             _debug_println(it)
//             // ok: Ar - it >= D
//             if (A[r] - it < D) break
//             it = set.ceiling(A[r])!!
//             _debug_println(it)
//             // ok: it - Ar >= D
//             if (it - A[r] < D) break
//             set.add(A[r]);
//             r++
//         }
//         ans += r - l
//         set.remove(A[l])
//     }
//     println(ans)
// }
//
