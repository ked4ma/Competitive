package com.github.ked4ma.competitive.atcoder.abc384

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.cumlative.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, S) = nextLongList().let { (N, S) -> N.toInt() to S }
    val A = nextLongList()
    val sum = A.sum()

    val s = S % sum

    val set = (A + A).cumulativeSum().toSet()
    for (p in set) {
        if (p + s in set) {
            println("Yes")
            return
        }
    }
    println("No")
}

// fun main() {
//     val (N, S) = nextLongList().let { (N, S) -> N.toInt() to S }
//     val A = nextLongList()
//     val cum = A.cumulativeSum()
//     val cum2 = (A.asReversed() + A.asReversed()).cumulativeSum()
//     val sum = A.sum()
//     val n = if (S < sum) {
//         S + sum
//     } else {
//         S - sum * (S / sum - 1)
//     }
//     _debug_println(sum)
//     _debug_println(cum)
//     _debug_println(cum2)
//     _debug_println("n = $n")
//     for (c in cum) {
//         if (c > n) continue
//         val j = cum2.lowerBound(n - c)
//         if (j < cum2.size && c + cum2[j] == n) {
//             println("Yes")
//             return
//         }
//     }
//     println("No")
// }