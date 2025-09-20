package com.github.ked4ma.competitive.common.acl.zalgorithm.array.int

import com.github.ked4ma.competitive.common.array.int.d1.*
import kotlin.math.min

// https://github.com/atcoder/ac-library/blob/master/atcoder/string.hpp#L247-L273
fun IntArray.zAlgorithm(): IntArray {
    val n = this.size
    if (n == 0) return IntArray(0)
    val z = sizedIntArray(n + 1, 0)
    z[0] = 0;
    var i = 1
    var j = 0
    while (i < n) {
        var k = if (j + z[j] <= i) 0 else min(j + z[j] - i, z[i - j])
        while (i + k < n && this[k] == this[i + k]) k++
        z[i] = k
        if (j + z[j] < i + z[i]) j = i
        i++
    }
    z[0] = n;
    return z;
}
