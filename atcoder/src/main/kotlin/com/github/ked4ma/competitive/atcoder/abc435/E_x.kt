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
}
