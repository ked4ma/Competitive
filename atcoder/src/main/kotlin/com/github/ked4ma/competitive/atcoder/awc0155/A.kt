package com.github.ked4ma.competitive.atcoder.awc0155

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = times(N) { next() }
    var ans = 1
    var m = 0
    for (i in 0 until N) {
        val s = S[i]
        var cnt = 0
        for (j in 0 until s.length - 8 + 1) {
            if (s.slice(j until j + 8) == "tanabata") cnt++
        }
        if (cnt > m) {
            m = cnt
            ans = i + 1
        }
    }
    println(ans)
}
// fun main() {
//     val N = nextInt()
//     val S = times(N) { next() }
//     val t = "tanabata"
//     var ans = 1
//     var m = 0
//     for (k in 0 until N) {
//         val s = S[k]
//         var cnt = 0
//         var i = 0
//         var j = 0
//         while (i < s.length) {
//             if (s[i] == t[j]) {
//                 j++
//                 if (j == t.length) {
//                     j = 2
//                     cnt++
//                 }
//             } else if (s[i] == 't') {
//                 j = 1
//             } else {
//                 j = 0
//             }
//             i++
//         }
//         if (cnt > m) {
//             m = cnt
//             ans = k + 1
//         }
//         _debug_println(cnt)
//     }
//     println(ans)
// }
