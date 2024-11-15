package com.github.ked4ma.competitive.common.list.long.bound

// ref: https://webbibouroku.com/Blog/Article/cs-lowerbound-upperbound
// A = [1, 1, 2, 3, 3, 4], v = 3
//               ↑
// returns index "3"
// ==========
// A = [1, 1, 3, 4, 4, 6], v = 2
//            ↑
// returns index "2"
fun List<Long>.lowerBound(v: Long): Int {
    var l = 0
    var r = this.lastIndex
    while (l <= r) {
        val m = (l + r) / 2
        if (this[m] < v) {
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
fun List<Long>.upperBound(v: Long): Int {
    var l = 0
    var r = this.lastIndex
    while (l <= r) {
        val m = (l + r) / 2
        if (this[m] <= v) {
            l = m + 1
        } else {
            r = m - 1
        }
    }
    return l
}
