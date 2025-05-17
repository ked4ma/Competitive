package com.github.ked4ma.competitive.atcoder.abc405

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val N2 = N * 2

    // ref: https://youtu.be/U-q-sdSj7dU?t=8209
    val nest = sizedLongArray(N2, 0)
    repeat(M) {
        val (A, B) = nextIntList().map { it - 1 }
        nest[A] = 1
        nest[B] = -1
    }
    for (i in 1 until N2) {
        nest[i] += nest[i - 1]
    }
    val segTree = SegmentTree.RAQ_RmQ(size = N2)
    segTree.init(nest)

    val Q = nextInt()
    val ans = mutableListOf<Long>()
    repeat(Q) {
        val (C, D) = nextIntList().map { it - 1 }
        val lca = segTree.query(C, D + 1).toInt()
        ans.add(nest[C] + nest[D] - 2 * lca)
    }

    // val dif = sizedIntArray(N2, 0)
    // repeat(M) {
    //     val (A, B) = nextIntList().map { it - 1 }
    //     dif[A] = 1
    //     dif[B] = -1
    // }

    // val edges = mutableListOf<Pair<Int, Int>>()
    // val vid = sizedIntArray(N2, 0)
    // var vs = 1
    // run {
    //     val stack = Stack<Int>()
    //     stack.push(0)
    //     for (i in range(N2)) {
    //         if (dif[i] == 0) {
    //             vid[i] = stack.peek()
    //         } else {
    //             if (dif[i] == 1) {
    //                 edges.add(stack.peek() to vs)
    //                 stack.push(vs)
    //                 vs++
    //             } else {
    //                 stack.pop()
    //             }
    //         }
    //     }
    // }
    // val lca = LCATree(vs)
    // for ((a, b) in edges) {
    //     lca.addEdge(a, b)
    // }
    // lca.build()

    // val Q = nextInt()
    // val ans = mutableListOf<Int>()
    // repeat(Q) {
    //     val (C, D) = nextIntList().map { it - 1 }
    //     ans.add(lca.distance(vid[C], vid[D]))
    // }
    println(ans.joinToString("\n"))
}
