package com.github.ked4ma.competitive.common.math.prime

import com.github.ked4ma.competitive.common.array.boolean.d1.*

// create prime list (smaller than or equals to "max" value)
// e.g.
// max: 11
// prime list: [2, 3, 5, 7, 11]
fun primes(max: Int) = buildList {
    val arr = sizedBooleanArray(max + 1, false)
    for (i in 2..max) {
        if (arr[i]) continue
        add(i.toLong())
        for (j in i until max step i) {
            arr[j] = true
        }
    }
}
