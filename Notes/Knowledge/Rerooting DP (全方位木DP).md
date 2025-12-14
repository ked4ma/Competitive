#tree #dp #dp/rerooting
- https://ei1333.hateblo.jp/entry/2017/04/10/224413
## Practices
- https://atcoder.jp/contests/dp/tasks/dp_v
- https://atcoder.jp/contests/njpc2017/tasks/njpc2017_e
- https://atcoder.jp/contests/s8pc-4/tasks/s8pc_4_d

自分なりに迷いづらかったのは、
1. 任意の根から`dfs`で問題の解を計算
   ```kotlin
   fun dfs(u: Int = 0, p: Int = -1) {
	   ...
	   for(v in G[u]) {
		   dfs(v, u)
	   }
	   ...
   }
   ```
2. 別の`dfs`で木を下りながら各頂点の解を計算
   ```kotlin
   fun dfs2(u: Int = 0, p: Int = -1) {
	   // calc ans
	   for (v in G[u]) {
		   ...
	   }

	   for (v in G[u]) {
		   if (v == p) continue
		   ...
		   dfs2(v, u)
	   }
   }
   ```
	- ここで、子頂点に下るための`for`の中ではなるべく値を使い回さないようにしたほうが良い。
	- 使いまわすと思いもしない差分が発生して混乱の素になる

- `p_var`のように親からの値を引き回してもいいのだが、それはそれで考えることが増えるので**個人的には**合わなかった