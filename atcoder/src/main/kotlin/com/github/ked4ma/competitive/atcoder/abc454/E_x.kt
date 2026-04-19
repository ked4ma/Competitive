package com.github.ked4ma.competitive.atcoder.abc454

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    var (N, A, B) = nextIntList()
    A--
    B--
    if (N % 2 == 1 || (A + B) % 2 == 0) {
        println("No")
        return
    }
    println("Yes")
    var s = ""
    var t = ""
    var h = N
    var w = N
    while (true) {
        if (A >= 2) {
            s += "${"R".repeat(w - 1)}D"
            s += "${"L".repeat(w - 1)}D"
            h -= 2
            A -= 2
        } else if (A < h - 2) {
            t += "${"R".repeat(w - 1)}D"
            t += "${"L".repeat(w - 1)}D"
            h -= 2
        } else if (B >= 2) {
            s += "${"D".repeat(h - 1)}R"
            s += "${"U".repeat(h - 1)}R"
            w -= 2
            B -= 2
        } else if (B < w - 2) {
            t += "${"D".repeat(h - 1)}R"
            t += "${"U".repeat(h - 1)}R"
            w -= 2
        } else {
            if (A == 0) {
                s += "DR"
            } else {
                s += "RD"
            }
            break
        }
    }
    println("$s${t.reversed()}")
}
