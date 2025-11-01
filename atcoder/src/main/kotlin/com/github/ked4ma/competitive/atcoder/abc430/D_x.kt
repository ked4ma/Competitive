package com.github.ked4ma.competitive.atcoder.abc430

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val X = nextLongList()

    val list = sortedSetOf(0L)
    val pair = mutableMapOf(0L to LONG_INF)

    var sum = LONG_INF
    for (x in X) {
        _debug_println(list)
        _debug_println(pair)
        val l = list.floor(x)!!
        val r = list.ceiling(x)
        _debug_println("$l $r")
        if (r == null) {
            val d = pair.getValue(l)
            val d2 = x - l
            if (d > d2) {
                sum -= d
                sum += d2
                pair[l] = d2
            }
            pair[x] = d2
            sum += d2
        } else {
            val dl = pair.getValue(l)
            val dr = pair.getValue(r)
            _debug_println("dist: $dl $dr")
            val ndl = x - l
            val ndr = r - x
            _debug_println("n-dist: $ndl $ndr")
            if (dl > ndl) {
                sum -= dl
                pair[l] = ndl
                sum += ndl
            }
            if (dr > ndr) {
                sum -= dr
                pair[r] = ndr
                sum += ndr
            }
            pair[x] = min(ndl, ndr)
            sum += min(ndl, ndr)
        }
        list.add(x)
        println(sum)
    }
}
