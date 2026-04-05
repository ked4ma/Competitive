#tree #tree/mimimum_spanning_tree 
最小全域木を求める (類似: プリム法)
- 辺のコストで昇順にソート
- コストが小さい方から見ていき、閉路ができないなら採択する
	- UnionFindですでに同一連結成分にいるかで判定可能
- N - 1選ばれるまでループ

- https://algo-logic.info/kruskal-mst/