2D座標平面上に点があり、それらの各点に関して原点などからの位置関係に基づいて何かしらの処理を必要とする場合がある。
![[Screenshot from 2026-01-25 21-23-20.png]]
そのときに使えるものとしては $atan2(y, x)$ があるが、これは場合によっては丸め誤差による影響が出かねない。
特に各点について重要なのが点間の原点を中心とした「なす角」である場合、外積を利用したソート(偏角ソート)が利用できる。
### 注意
偏角ソートを行う場合、$5\degree$ と $345\degree$ のベクトルのなす角を求めたい場合などの場面で、外積を利用できないケースがあるので実装時にケアが必要。
これを考慮した比較関数としては以下のようにできる。
```kotlin
fun cmp(a: LongVec, b: LongVec): Int {
    // 半平面(上/下)を計算
    val ah = if (a.y < 0 || (a.y == 0L && a.x < 0)) 1 else 0
    val bh = if (b.y < 0 || (b.y == 0L && b.x < 0)) 1 else 0
	// 別々の平面であればその時点で比較
    if (ah != bh) return ah - bh
	// ↓同一半平面である場合に外積を利用する
    val c = a.cross(b)
    if (c == 0L) return 0
    return if (c > 0) -1 else 1
}
```

# Practices
- https://atcoder.jp/contests/abc442/tasks/abc442_e
