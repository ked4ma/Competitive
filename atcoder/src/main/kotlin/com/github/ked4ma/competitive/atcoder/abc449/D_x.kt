package com.github.ked4ma.competitive.atcoder.abc449

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (l, r, d, u) = nextLongList()

    fun f(l: Long, r: Long): Long {
        var nl = l + 10_000_000
        var nr = r + 10_000_000
        if (nl % 2 == 1L) nl++
        if (nr % 2 == 1L) nr--
        return (nr - nl) / 2 + 1
    }

    var ans = 0L
    for (y in d..u) {
        val w = abs(y)
        ans += f(l, r)
        val nl = max(l, -w)
        val nr = min(r, w)
        if (nl <= nr) {
            ans -= f(nl, nr)
            if (w % 2 == 0L) ans += nr - nl + 1
        }
    }
    println(ans)
}

// fun main() {
//     var (L, R, D, U) = nextLongList()
//
//     var ans = 0L
//     while (L <= R && D <= U) {
//         val h = U - D + 1
//         val w = R - L + 1
//         val mx = maxOf(R, U, -L, -D)
//         for (i in 0 until 4) {
//             if (mx == R) break
//             //  u      l
//             // l r -> d u
//             //  d      r
//             val tmp = L
//             L = D; D = -R; R = U; U = -tmp
//         }
//         if (R % 2 == 0L) ans += U - D + 1
//         R--
//     }
//     println(ans)
// }

// fun main() {
//     val (L, R, D, U) = nextLongList()
//
//     var ans = 0L
//     for (w in 0..1_000_000L) {
//         val sign = if (w % 2 == 0L) 1 else -1
//         val nl = max(-w, L)
//         val nr = min(w, R)
//         val nd = max(-w, D)
//         val nu = min(w, U)
//         if (nl <= nr && nd <= nu) ans += (nr - nl + 1) * (nu - nd + 1) * sign
//     }
//     println(ans)
// }
