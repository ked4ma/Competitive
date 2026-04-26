#tree #tree/segtree
## 区間更新・区間二乗和
単純な区間更新・区間和ではなく、区間に関して二乗和を知りたいとき、SegTreeを用いることができる。
まず前提として普通の区間和での更新を考えると、
$$
\begin{align}
x \rightarrow x + a
\end{align}
$$
なので、もとの区間和の値に$a *$区間の**長さ**とすればよい。

これを二乗の場合にも適用する。
更新($+a$すると仮定)することを考えると、
$$
\begin{align}
x^2 \rightarrow (x + a)^2 = x^2 + 2ax + a^2
\end{align}
$$
となるが、これを区間に対して適用することを考えると、
- $2ax$に関しては$x$の**区間和**
- $a^2$に関しては区間の**長さ**がわかればいい

なので、実装としては以下のようにできる。
(同様にして考えていくと、三乗和とかもできるはず。らしい。)
$s0$: 0乗和(区間の長さ)
$s1$: 1乗和(区間和)
$s2$: 2乗和(区間二乗和)

```kotlin
    data class D(val s0: Long, val s1: Long, val s2: Long)

    val op: Op<D> = { a, b ->
        D(a.s0 + b.s0, a.s1 + b.s1, a.s2 + b.s2)
    }
    val mapping: Mapping<D, Long> = { x, f ->
        x.copy(
            s1 = x.s1 + x.s0 * f,
            s2 = x.s2 + x.s1 * f * 2 + x.s0 * f * f,
        )
    }
    val composition: Composition<Long> = { f, g ->
        f + g
    }
    val e = D(0, 0, 0)
    val id = 0

    val segTree = GeneralLazySegmentTree.instanceOf<D, Long>(
        N,
        op = op,
        mapping = mapping,
        composition = composition,
        e = e,
        id = id,
    )
```
## Practices
- https://atcoder.jp/contests/abc455/tasks/abc455_f