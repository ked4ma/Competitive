package com.github.ked4ma.competitive.atcoder.arc227

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.output.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.fenwick.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList().sorted()
    if (A[0] != 0) {
        println("No")
        return
    }
    val stack = Stack<Int>()
    val ft = FenwickTree(500_005)
    ft.add(0, 1)
    val ans = sizedIntArray(N)
    var i = 1
    var ai = 1
    while (i < N) {
        if (ai < N) {
            if (A[ai] == A[ai - 1]) {
                stack.push(A[ai])
                _debug_println("${ans.joinToString(" ")}: $i $ai [$stack] / ($A)")
                ai++
                continue
            }
            if (ft.sum(0, A[ai]).toInt() == A[ai]) {
                ans[i] = A[ai]
                ft.add(A[ai], 1)
                ai++
            } else {
                if (stack.isEmpty()) {
                    println("No")
                    return
                }
                val a = stack.pop()
                ans[i] = a
                ft.add(a, 1)
            }
        } else {
            ans[i] = stack.pop()
        }
        _debug_println("${ans.joinToString(" ")}: $i $ai $stack / $A")
        i++
    }
    println("Yes")
    ans.println(" ")
    _debug_println(stack)
}
