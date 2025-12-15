#math #math/divider
整数$N$の約数を列挙したいことがある。
普通にやろうとすると、$i=1..N$ の各値で割り切れるかを確認する必要があるので$O(N)$かかる

ただし、 $N=i*\alpha$とかけることから、$i$も$\alpha$も$N$の約数であることは自明。
なので実際に確認する飛鳥があるのは$\sqrt{N}$までで十分になる。
こうすることで$O(\sqrt{N})$まで削減できる

### 疑似コード
```kotlin
val N: Long
var i = 1L
while (i * i <= N) {
  if (N % i == 0L) {
    // do something
  }
  i++
}
```
