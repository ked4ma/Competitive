#math #math/gcd

## 概要
gcdは数を素因数分解し、各累乗の肩の値のminをとったもの
$$
\begin{align}
n &= a^{i1} * b ^ {j1} * c ^ {k1} \\
m &= a^{i2} * b ^ {j2} * c ^ {k2} \\
gcd(n, m) &= a ^ {min(i1, i2)} * b ^ {min(j1, j2)} * c ^ {min(k1, k2)}
\end{align}
$$

## gcd(a, b, c)なんかを扱いたい場合
### CASE.1 
「$gcd(a, b, c) = x$になる$x$」を見つけるのは難しいし大変だが、
「$gcd(a, b, c) = xの倍数$となる$x$」を見つけるのはもう少し楽にできる
やりざまとしては
1. 各入力の出現をカウント
   ```kotlin
   val arr = sizedIntArray(M + 1)
   for (a in A) {
     arr[a]++
   }
   ```
2. 入力の最大値をMとしたとき、各約数となる数をカウント
   ```kotlin
   val cnt = sizedIntArray(M + 1)
   for (i in 1 .. M) { // 約数
     for (j in i .. M step i) { // iの倍数
	   cnt[i] += arr[j]
	 }
   }
   ```
3. この例では$a, b, c$の3変数を扱うので、2の値が3以上になるものは入力の組み合わせ次第で「$xの倍数となる$もの」を作ることが可能
### CASE.2
ある数値列があって、それらを使って作れる最大のgcdを見つけたい。
**CASE.1の配列を利用することで可能**
考え方としてはCASE.1同様、「$x$の倍数となるもの」という考え方。
例えばあるgcdが5の倍数であるなら、10も15も**少なくとも5の倍数**であるとして解の下限を設定することができる。
なので、小さい値からそのgcdが条件を満たすほかの倍数もマークしていく
```kotlin
val arr2 = sizedIntArray(M + 1)
for (i in 1..M) { // 約数
    if (cnt[i] < K) continue // e.g. その約数の出現回数がKに満たない場合は無視
    for (j in i..M step i) { // 約数iの倍数も少なくともiは満たす(下限)
        arr2[j] = i
    }
} 
```
というようにすれば、ある数$x$から作ることができる最大のgcdを$arr[x]$で取ることができる。