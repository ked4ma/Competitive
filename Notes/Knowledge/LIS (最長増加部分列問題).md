#dp #dp/lis
Longest Increasing Subsequence
- https://qiita.com/drken/items/68b8503ad4ffb469624c

## サンプルコード
### 狭義単調増加の場合 ($a_i \lt a_j$)
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
### 広義単調増加の場合 ($a_i \le a_j$)
```kotlin
private fun lis(P: List<Int>): Int {
    val n = P.size
    val arr = sizedIntArray(n, INT_INF)
    for (i in 0 until n) {
        val p = P[i]
        val j = arr.upperBound(p)
        arr[j] = p
    }
    return arr.lowerBound(INT_INF)
}
```
※差としては更新位置 $j$ を求めるときに使うものが `lowerBound` か `upperBound` か
# Practices
- https://atcoder.jp/contests/abc439/tasks/abc439_e
	- a little bit tricky
- https://atcoder.jp/contests/awc0155/tasks/awc0155_e