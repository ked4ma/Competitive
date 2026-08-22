#string #combination #sort
```
S = ["123", "12", "111", "0001", ...]
のような文字列が与えられたとき、これらを連結した文字列が最大の数字になるように並べかえよ
```
と言われたとき、 ある要素 $A$, $B$ に関して $AB > BA$ となるようにソートすることで達成できる

## 軽い証明
各値を少数として捉える。
$$
\begin{align}
\begin{cases}
	123  \\
    12   \\
    111  \\
    0001
\end{cases} \rightarrow
\begin{cases}
	0.123 \\
	0.12  \\
	0.111 \\
	0.0001
\end{cases}
\end{align}
$$
コレに対してある要素 $A$, $B$ を連結すると (e.g. $A = 0.123$, $B = 0.12$)
$$
\begin{align}
AB =& A + B * 10^{-3} \\
BA =& B + A * 10^{-2} 
\end{align}
$$
と言い変えられる。$10^{-3}$, $10^{-2}$はそれぞれ$A$,$B$の桁数に関連する値なので $t_a$, $t_b$ とおくと
これが $AB > BA$ のとき、
$$
\begin{align}
AB >& BA \\
\rightarrow A + B * t_a >& B + A * t_b \\
\rightarrow A * (1 - t_b) >& B * (1 - t_a) \\
\rightarrow \frac{A}{1 - t_a} >& \frac{B}{1 - t_b}
\end{align}
$$
とでき、全順序(任意の2要素間で必ず順序関係が成り立つ関係)であることがわかる

## ref
- https://drken1215.hatenablog.com/entry/2022/12/16/194300