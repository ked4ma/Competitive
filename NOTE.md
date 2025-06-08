# NOTES

## prim's theory
- https://algo-logic.info/prim-mst/

## kruskal mst
- https://algo-logic.info/kruskal-mst/
- use union-find

## rotate 2D-matrix
- clockwise
  ```kotlin
  for (i in 0 until H) {
      for (j in 0 until W) {
          arr2[j][H - 1 - i] = arr[i][j]
      }
  }
  ```
- anti-clockwise
  ```kotlin
  for (j in 0 until H) {
      for (j in 0 until W) {
          arr2[H - 1 - j][i] = arr[i][j]
      }
  }
  ```

## tree's centroid
- https://atcoder.jp/contests/abc291/editorial/5840
- https://atcoder.jp/contests/abc348/editorial/9706

## Rerooting DP
- https://ei1333.hateblo.jp/entry/2017/04/10/224413

## LIS
- https://qiita.com/drken/items/68b8503ad4ffb469624c
