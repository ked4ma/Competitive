#combination 
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
