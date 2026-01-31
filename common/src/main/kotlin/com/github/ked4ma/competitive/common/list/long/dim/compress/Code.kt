package com.github.ked4ma.competitive.common.list.long.dim.compress

// compress list values to size relationship
fun List<Long>.compress(): List<Int> {
    val xs = this.sorted().distinct()
    return buildList {
        for (x in this@compress) {
            add(xs.binarySearch(x))
        }
    }
}
