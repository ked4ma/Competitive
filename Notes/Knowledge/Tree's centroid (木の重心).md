#tree #tree/centroid
木の重心を求めたいとき、まずはある頂点Aから隣接する頂点Bに移動することを考えてみる。
- ![[Screenshot from 2026-04-30 00-19-54.png]]
そのとき、頂点を移動する=移動先方向にある頂点への移動コストがそれぞれの頂点に関して-1, 逆方向にある頂点への移動コストがそれぞれ+1されることに等しい。
(もし各頂点にweightが設定されている場合はそれをそれぞれ掛けたもの)
なので、頂点移動することによるトータルの移動コストは
$$
\begin{align}
C \rightarrow C - \sum{C_i} + \sum{C_j}
\end{align}
$$
そのような移動を繰り返し、もうこれ以上移動する旨味がなくなる場所が木の重心となる。
そしてそのような頂点は**必ず存在する**。
移動する意味がなくなるのは、以下のように
**「各部分木のサイズ」のmaxが最小になる頂点** である。
もしくは移動する旨味がなくなるのは、**「各部分木のサイズ」のmax** が全体コストの半分以下になるときとも言える(=なぜならどこに行っても差し引き増加しかしなくなるため)
![[Screenshot from 2026-04-30 00-26-22.png]]
コードで書くと以下のような形で重心の頂点を求められる
```kotlin
    val total = C.sum()
    // 重心の頂点
    var x = -1 
    fun dfs(u: Int = 0, p: Int = -1): Long {
        var res = C[u]
        var mx = 0L
        for (v in G[u]) {
            if (v == p) continue
            // 各部分木
            val now = dfs(v, u)
            mx = max(mx, now) 
			
            res += now
        }
		// 親の部分木
        mx = max(mx, total - res)
        if (mx * 2 <= total) x = u
        return res
    }
    dfs()
```
## Practices
- https://atcoder.jp/contests/abc291/editorial/5840
- https://atcoder.jp/contests/abc348/editorial/9706