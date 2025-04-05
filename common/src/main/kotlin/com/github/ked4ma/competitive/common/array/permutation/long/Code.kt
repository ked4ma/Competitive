package com.github.ked4ma.competitive.common.array.permutation.long


// calc next permutation of array.
// CAUTION1: this method will break array.
// CAUTION2: be sure that array is sorted at first.
//
// @return true if there is next permutation. otherwise return false
fun LongArray.nextPermutation(): Boolean {
    val n = this.size
    if (n == 1) return false
    var i = n - 2
    while (i > 0 && this[i] >= this[i + 1]) {
        i--
    }
    var j = n - 1
    while (j > i && this[i] >= this[j]) {
        j--
    }
    if (i == j) return false
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
    this.reverse(i + 1, n)
    return true
}