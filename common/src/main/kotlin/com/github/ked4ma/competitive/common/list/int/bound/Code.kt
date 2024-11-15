package com.github.ked4ma.competitive.common.list.int.bound

// ref: https://webbibouroku.com/Blog/Article/cs-lowerbound-upperbound
// A = [1, 1, 2, 3, 3, 4], v = 3
//               ↑
// returns index "3"
fun List<Int>.lowerBound(v: Int): Int {
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
fun List<Int>.upperBound(v: Int): Int {
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
