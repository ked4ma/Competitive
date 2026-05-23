#dp 

## N以下の〇〇
桁DPをするとき、「N以下の〇〇」を計算したいことが多い。
その時、入力値Nに対して +1 しておくと、「N**未満**の〇〇」とでき、
最後の出力値を取るのが楽になる。

## bit桁DPでのforの回し方
$$
dp[i][j] := 
	\begin{cases}
		i桁目まで決めたとき \\
		N以下が確定しているか(j=0:一致, 1:以下)
	\end{cases}
$$
というようにしたとき、以下のようにすると割とスッキリ書けそう
```kotlin
for (i in M - 1 downTo 0) {
	for (j in 0 until 2) {
		val now = dp[i + 1][j]
		for (a in 0 until 2) { // その桁として何を使うか
			var nj = j
			if (j == 0) {
				if (a < N.bitAt(i)) nj = 1
				if (a > N.bitAt(i)) continue
			}
			// やりたい計算
			// dp[i][nj] += now * hoge
		}
	}
}
```
