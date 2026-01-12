#combination
数え上げのテクニックとして使える
![[Screenshot from 2025-09-28 17-46-01.png]]
- $aCb$ の$a$が何段目か、$b$がその段の何個目の要素かを示す。
- これを使う利点としては、足し合わせのみで各組み合わせ数を計算できるため、 $mod$ などの値に影響を受けない
- ($inv$を使う方法では$mod$の値によっては求められない)

### サンプルコード
```kotlin
    val pascal = sizedArray(N + 1) { it ->
        sizedLongArray(it + 1, 0)
    }
    pascal[0][0] = 1
    for (i in 0 until N) {
        for (j in 0 until i + 1) {
            pascal[i + 1][j] += pascal[i][j]
            pascal[i + 1][j] %= MOD
            pascal[i + 1][j + 1] += pascal[i][j]
            pascal[i + 1][j + 1] %= MOD
        }
	}    
```

### Usage
$aCb$をそのまま利用する感じで使える
```kotlin
val n = pascal[3][2]    // 3C2
val n = pascal[24][8]   // 24C8
val n = pascal[1000][0] // 1000C0
```

