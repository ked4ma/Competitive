package com.github.ked4ma.competitive.atcoder.abc445

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    var (H, W, N) = nextIntList()
    val hQueue = PriorityQueue<D>(compareByDescending { it.h })
    val wQueue = PriorityQueue<D>(compareByDescending { it.w })
    repeat(N) { i ->
        val (h, w) = nextIntList()
        hQueue.offer(D(i, h, w))
        wQueue.offer(D(i, h, w))
    }
    val ans = sizedArray(N) { 0 to 0 }
//    val check = sized2DBooleanArray(H, W)
    repeat(N) {
        while (hQueue.peek().h > H || ans[hQueue.peek().index] != 0 to 0) hQueue.poll()
        while (wQueue.peek().w > W || ans[wQueue.peek().index] != 0 to 0) wQueue.poll()
        if (hQueue.peek().h == H) {
            val (i, h, w) = hQueue.poll()
            ans[i] = (H - h + 1) to (W - w + 1)
            W -= w
//            _debug_println("$H $W ($i) : ${ans[i]}, ${verify(check, ans[i].first, ans[i].second, h, w)}")
        } else if (wQueue.peek().w == W) {
            val (i, h, w) = wQueue.poll()
            ans[i] = (H - h + 1) to (W - w + 1)
            H -= h
//            _debug_println("$H $W ($i) : ${ans[i]}, ${verify(check, ans[i].first, ans[i].second, h, w)}")
        }
    }
    println(ans.joinToString("\n") { "${it.first} ${it.second}" })
}

private data class D(val index: Int, val h: Int, val w: Int)

// private fun verify(check: Array<BooleanArray>, h: Int, w: Int, hLen: Int, wLen: Int): Boolean {
//     for (i in h - 1 until h - 1 + hLen) {
//         for (j in w - 1 until w - 1 + wLen) {
//             if (check[i][j]) return false
//             check[i][j] = true
//         }
//     }
//     return true
// }
//
