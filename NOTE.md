# NOTES

## prim's theory
- https://algo-logic.info/prim-mst/

## kruskal mst
- https://algo-logic.info/kruskal-mst/
- use union-find

## rotate 2D-matrix
- clockwise
  ```kotlin
  for (i in 0 until N) {
      for (j in 0 until N) {
          arr[j][N - 1 - i] = arr[i][j]
      }
  }
  ```
- anti-clockwise
  ```kotlin
  for (j in 0 until N) {
      for (j in 0 until N) {
          arr[N - 1 - j][i] = arr[i][j]
      }
  }
  ```