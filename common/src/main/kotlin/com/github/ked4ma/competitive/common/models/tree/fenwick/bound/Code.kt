package com.github.ked4ma.competitive.common.models.tree.fenwick.bound

import com.github.ked4ma.competitive.common.models.tree.fenwick.*

// ref: https://webbibouroku.com/Blog/Article/cs-lowerbound-upperbound
// A = [1, 1, 2, 3, 3, 4], v = 3
//               ↑
// returns index "3"
// ==========
// A = [1, 1, 3, 4, 4, 6], v = 2
//            ↑
// returns index "2"
fun FenwickTree.lowerBound(v: Long): Int {
    var l = 0
    var r = this.size - 1
    while (l <= r) {
        val m = (l + r) / 2
        if (this.sum(0, m + 1) < v) {
            l = m + 1
        } else {
            r = m - 1
        }
    }
    return l
}

// ref: https://webbibouroku.com/Blog/Article/cs-lowerbound-upperbound
// A = [1, 1, 2, 3, 3, 4], v = 3
//                     ↑
// returns index "5"
fun FenwickTree.upperBound(v: Long): Int {
    var l = 0
    var r = this.size - 1
    while (l <= r) {
        val m = (l + r) / 2
        if (this.sum(0, m + 1) <= v) {
            l = m + 1
        } else {
            r = m - 1
        }
    }
    return l
}
