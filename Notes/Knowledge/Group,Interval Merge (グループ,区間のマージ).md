#group #interval 
隣接関係のあるグループやマス目などの区間のマージを行いながら何かしらの計算(長さなど)を行いたい場合、いくつかやりようがある

## 1. UnionFind
 区間という印象は薄くなるが、できる。
 ![[Screenshot from 2026-01-20 01-06-28.png]]
 上のように、「同じグループに属する」というようなことを表現するのがまさにUnionFindなのでそれを利用する。
 ただ、これだけだと「条件を満たす隣接グループと統合する」ということができないので、
 別途 $l$と$r$を配列などで持ち、マージ時に一緒に更新する必要はある。

### 疑似コード
```kotlin
val uf = UnionFind(N + 2)
val l = sizedIntArray(N + 2) { it }
val r = sizedIntArray(N + 2) { it }
...
// root of the target
x = uf.find(x)
...
// merge (left)
run {
	// left group index
    val li = uf.find(l[x] - 1)
    if (col[li] == c) { // merge judgement
        val nl = l[li]  // next l (after merged)
        val nr = r[x]   // next r (after merged)
        uf.unite(li, x) // merge group
        x = uf.find(x)  // next root (targe group + left group)
        l[x] = nl
        r[x] = nr
        col[x] = c
    }
}    
// merge (right)
...
``` 

## 2. Set/Map
下のように各区間の左端を持つ方法。
区間同士をマージ=右側のグループの左端をSet/Mapから落とす
と言えるので、マージ処理自体が簡素。
※右端情報は欠落しているので、最左右端に番兵を置くなどして確実に存在、rを計算できるようにしてあげる必要があるケースもあるので注意
![[Screenshot from 2026-01-20 01-13-51.png]]

### 疑似コード
```kotlin
// init map
val map = TreeMap<Int, Int>() // left, color
for (i in 0 until N + 2) {
    map[i] = i
}
...
// left of the target group
val l = map.floorKey(x)
// right of the target group (exclusive = left of right group)
val r = map.ceilingKey(x + 1)
...
// merge (left)
run {
	// left of the left group
    val li = map.floorKey(l - 1)
    if (map.getValue(li) == c) { // merge judgement
        map.remove(l)
    }
}
// merge (right)
run {
    val ri = r
    if (map.getValue(ri) == c) { // merge judgement
        map.remove(ri)
    }
}
```

## Practices
- https://atcoder.jp/contests/abc380/tasks/abc380_e