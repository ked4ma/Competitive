#dp #dp/lis
Longest Increasing Subsequence
- https://qiita.com/drken/items/68b8503ad4ffb469624c

## サンプルコード
```kotlin
private fun lis(P: List<Int>): Int {
    val n = P.size
    val arr = sizedIntArray(n, INT_INF)
    for (i in 0 until n) {
        val p = P[i]
        val j = arr.lowerBound(p)
        arr[j] = p
    }
    return arr.lowerBound(INT_INF)
}
```

# Practices
- https://atcoder.jp/contests/abc439/tasks/abc439_e
	- a little bit tricky