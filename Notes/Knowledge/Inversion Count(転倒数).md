#math #math/inversion_count
- BITやSegTreeを使って高速に求められる
- 転倒数を求めるときは
$$
\begin{gather}
\begin{bmatrix}
a_1 & a_2 & a_3 & a_4 & a_5
\end{bmatrix} \\
\text{があるとき、} a_i > a_j \text{となるi,jの組の数が転倒数になる}
\end{gather}
$$
- 考え方としては
	- $a_i > a_j$ となる組がある場合、いずれはこれらを直接swapする必要がある
	- １つでもこれらがの組が存在する場合、それはソート済みとはならない