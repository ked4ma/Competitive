package com.github.ked4ma.competitive.atcoder.abc464

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.combimation.mod.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.models.number.mod.long.experimental.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    MOD = MOD998244353
    val (N, X) = nextLongList().let { (N, X) -> N.toInt() to X }
    var nl = N / 2
    var nr = N - nl
    val A = nextLongList()
    val al = A.subList(0, nl)
    val ar = A.subList(nl, N)

    fun enums(a: List<Long>): Array<out List<Long>> {
        val n = a.size
        val d = sizedArray(n + 1) { mutableListOf<Long>() }
        d[0].add(0)
        for (i in 0 until n) {
            for (j in i downTo 0) {
                for (s in d[j]) d[j + 1].add(s + a[i])
            }
        }
        d.forEach { it.sort() }
        return d
    }

    var dl = enums(al)
    var dr = enums(ar)
    var sl = al.sum()
    var sr = ar.sum()

    val comb = CombinationMod(40)

    var ans = 0.mlong()
    repeat(2) {
        for (i in 0 until nl + 1) {
            for (j in 0 until nr) {
                val p = (comb.aCb(N, i + j) * (N - i - j)).mlong().inv()
                var li = dl[i].size
                for (s in dr[j]) {
                    while (li > 0 && dl[i][li - 1] + s >= X) li--
                    ans += p * li.mlong() * (sr - s).mlong()
                }
            }
        }
        dl = dr.also { dr = dl }
        nl = nr.also { nr = nl }
        sl = sr.also { sr = sl }
    }

    println(ans.toLong())
}

// fun main() {
//     MOD = MOD998244353
//     val (N, X) = nextLongList().let { (N, X) -> N.toInt() to X }
//     var nl = N / 2
//     var nr = N - nl
//     val A = nextLongList()
//     val al = A.subList(0, nl)
//     val ar = A.subList(nl, N)
//
//     fun enums(a: List<Long>): Array<out List<Long>> {
//         val n = a.size
//         val d = sizedArray(n + 1) { mutableListOf<Long>() }
//         d[0].add(0)
//         for (i in 0 until n) {
//             for (j in i downTo 0) {
//                 for (s in d[j]) d[j + 1].add(s + a[i])
//             }
//         }
//         d.forEach { it.sort() }
//         return d
//     }
//
//     var dl = enums(al)
//     var dr = enums(ar)
//     var sl = al.sum()
//     var sr = ar.sum()
//
//     val comb = CombinationMod(40)
//
//     var ans = 0.toModLong()
//     repeat(2) {
//         for (i in 0 until nl + 1) {
//             for (j in 0 until nr) {
//                 val p = (comb.aCb(N, i + j) * (N - i - j)).toModLong().inv()
//                 var li = dl[i].size
//                 for (s in dr[j]) {
//                     while (li > 0 && dl[i][li - 1] + s >= X) li--
//                     ans += p * li * (sr - s)
//                 }
//             }
//         }
//         dl = dr.also { dr = dl }
//         nl = nr.also { nr = nl }
//         sl = sr.also { sr = sl }
//     }
//
//     println(ans.toLong())
// }
//
