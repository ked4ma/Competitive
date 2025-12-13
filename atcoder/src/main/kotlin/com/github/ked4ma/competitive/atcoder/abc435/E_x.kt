package com.github.ked4ma.competitive.atcoder.abc435

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val s = sortedSetOf<Pair<Int, Int>>(compareBy { it.first })
    s.add(N + 5 to N + 5)

    var ans = N
    repeat(Q) {
        var (l, r) = nextIntList().let { (l, r) -> l - 1 to r }
        // [cpp]: auto it = s.lower_bound(P(l, -1));
        var itr = s.ceiling(l to -1)
        if (itr != null) {
            // [cpp]: if (it != s.begin() && prev(it)->second >= l) it--;
            val prev = s.lower(itr)
            itr = if (prev != null && prev.second >= l) prev else itr
            while (itr != null && itr.first <= r) {
                ans += itr.second - itr.first
                l = min(l, itr.first)
                r = max(r, itr.second)
                s.remove(itr)
                // it++
                itr = s.higher(itr)
            }
        }
        s.add(l to r)
        ans -= r - l
        _debug_println("next: $s")
        println(ans)
    }

    // https://atcoder.jp/contests/abc435/submissions/71648564
    // val (N, Q) = nextIntList()
    // val LR = times(Q) {
    //     val (L, R) = nextIntList()
    //     L - 1 to R
    // }
    // val values = (listOf(0, N) + LR.flatMap { (l, r) -> listOf(l, r) }).sorted().distinct()
    // val indexMap = values.withIndex().associate { it.value to it.index }
    // val segTree = LazySegmentTree.RUQ_RSQ(values.size - 1)
    // segTree.init((0 until values.size - 1).map { (values[it + 1] - values[it]).toLong() })
    // val ans = sizedLongArray(Q, 0)
    // for (i in 0 until Q) {
    //     val lr = LR[i]
    //     val l = indexMap.getValue(lr.first)
    //     val r = indexMap.getValue(lr.second)
    //     _debug_println("$l $r")
    //     segTree.update(l, r, 0)
    //     ans[i] = segTree.queryAll()
    // }
    // ans.println("\n")
}
