package com.github.ked4ma.competitive.atcoder.abc465

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    var (X, Y, K) = nextLongList()
    var ans = 0
    while (X != Y) {
        if (X > Y) {
            X /= K
        } else {
            Y /= K
        }
        ans++
    }
    println(ans)
}

// private fun solve() {
//     val (X, Y, K) = nextLongList()
//     data class D(val l: Long, val r: Long, val i: Int)
//
//     val queue = PriorityQueue<D>(compareBy { it.i })
//     run {
//         var x = X
//         var i = 0
//         while (true) {
//             queue.offer(D(x, x + 1, i))
//             if (x == 0L) break
//             x /= K
//             i++
//         }
//     }
//     while (queue.isNotEmpty()) {
//         _debug_println(queue.peek())
//         val (l, r, i) = queue.poll()
//         if (Y in l until r) {
//             println(i)
//             return
//         }
//         var nl = l * K
//         if (nl / K != l) nl = Long.MAX_VALUE
// //        val nl = try {
// //            Math.multiplyExact(l, K)
// //        } catch (_: RuntimeException) {
// //            Long.MAX_VALUE
// //        }
//         var nr = r * K
//         if (nr / K != r) nr = Long.MAX_VALUE
// //        val nr = try {
// //            Math.multiplyExact(r, K)
// //        } catch (_: RuntimeException) {
// //            Long.MAX_VALUE
// //        }
//         if (nl == Long.MAX_VALUE && nr == Long.MAX_VALUE) continue
//         queue.offer(D(nl, nr, i + 1))
//     }
//     println(-1)
// }
//
