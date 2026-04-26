#math #math/combination 
- 計算対象が以下のとき
$$
\sum_{i=0,1,...}\binom{l}{i + 1}\binom{r}{i} \tag{1}
$$
- ここで、二項係数に関して以下が自明に成り立つ
$$
\binom{a}{b} = \binom{a}{a - b}
$$
- これから $(1)$ は次のように変形できる
$$
\sum_{i=0,1,...}\binom{l}{i + 1}\binom{r}{i} = \sum_{i=0,1,...}\binom{l}{l - 1 - i }\binom{r}{i} \tag{2}
$$
- こうしたとき、この計算は以下のように、どの $i$ に関しても $l$,$r$ 合わせて同じ数だけ選ぶのと同義であることがわかる。
  ![[Screenshot from 2025-11-23 19-56-07.png]]
- このことから、$(2)$ はさらに以下のように変形できる
$$
\begin{align}
\sum_{i=0,1,...}\binom{l}{i + 1}\binom{r}{i} &= \sum_{i=0,1,...}\binom{l}{l - 1 - i }\binom{r}{i} \\
&= \binom{l + r}{l - 1}
\end{align}
$$
- これで計算対象を $O(1)$ で計算可能になる。

## Principle of Inclusion-Exclusion (包除原理)
組み合わせ問題などで直接命題を解くのが難しい場合、包除原理が使えないか考えてみてもいいかもしれない
![[Screenshot from 2026-04-26 18-17-59.png]]
- **例**: ある条件A,B,Cがあったとき、 AもBもCも満たさないものを数え上げたい
- このとき、$ABC(\times, \times, \times)$は
$$
\begin{align}
ABC(\times, \times, \times) = ABC(?, ?, ?) \\
\color{red}//1つは満たす \\
-ABC(\circ, ?, ?) \\
-ABC(?, \circ, ?) \\
-ABC(?, ?, \circ) \\
\color{red}//2つは満たす \\
+ABC(\circ, \circ, ?) \\
+ABC(?, \circ, \circ) \\
+ABC(\circ, ?, \circ) \\
\color{red}// 全部満たす \\
+ABC(\circ, \circ, \circ)
\end{align}
$$
と変換できる。
感覚としては条件を徐々に厳しくしながら前の条件で引きすぎたり足しすぎた分を調整していく感覚(多分条件が増えても同じようにできるはず)