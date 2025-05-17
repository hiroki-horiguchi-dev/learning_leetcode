## 1st
- 問題は 0,1 で与えられる二次元配列のうち、1 が上下左右いずれかが連結されているものを島とみなし、島の数を返却することを目的とする
- 回答方針が2パターンあるので両方やるで
- 制約
```markdown
Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
```

### DFS (depth-first search) ✅
- 方針としては、二次元配列を二重ループで回して全ての要素にアクセスする
- その要素について、上下左右が島なら海に変更する処理を再帰的に行えばよい
- 個人的にはこっちの方が直感的でわかりやすい
```java
class Solution {
    public int numIslands(char[][] grid) {

        int count = 0;

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                // 島があれば dfs かけて隣接している島を全て海に変更する
                if (grid[x][y] == '1') {
                    dfs(grid, x, y);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        // x, y 軸が溢れたら処理終了
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') return;

        // 海に変更する
        grid[x][y] = '0';

        // 上下左右に dfs かける
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
    }
}
```
- 計算量
  - grid 二重ループなんで問題文の制約から `O(n * m)`
- 空間計算量
  - 特に何も生成してないので O(1) ❌
    ![img.png](img.png)
  - スタックに乗って `O(n * m)` なんや、なるほどなあ
- ⚠️問題点⚠️
  - 再帰関数を使うため、スタックに乗るのでスタックオーバーフローが発生して落ちる可能性がある

### BFS (breadth-first search) ✅
- 方針
  - DFS とあんま変わらんが、池にぽちゃんと落とした石が波を起こすようなイメージが近いって言われてなるほどとなった
- [NUMBER OF ISLANDS - Leetcode 200 - Python](https://www.youtube.com/watch?v=pV2kpPD66nE) は BFS だね
- 直感的にわかりにくい、なんで Queue と LinkedList 使うねんって感じ
- 最初の 0,0 インデックスが与えられた時を input1 を例に考えると
```java
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == '1') {
                    bfs(grid, x, y);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int startX, int startY) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startX, startY});

        grid[startX][startY] = '0';  // visited にする

        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}  // 上下左右
        };

        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1') {
                    queue.offer(new int[] {nx, ny});
                    grid[nx][ny] = '0';
                }
            }
        }
    }
}
```
- 時間計算量
  - `O(m * n) `
- 空間計算量
  - `O(m * n)`

### DFS, BFS の違いとそれぞれに向いているパターン
![img_1.png](img_1.png)

## 2nd
- Tree_BFS をやる中で不意にこれどうやるんだっけ？って思って取り組んだい
- かかった時間が 30分程度。。まだまだ当たり前に解けている状態とは言い難い
- Tree_BFS をやっているからか、そちらに思考が少し持って行かれてしまったのが時間がかかった原因
- この問題はかなり素直な問題で、ただ島から海へ書き換えるためだけに再帰関数が便利だよね？に気付けば 5分で書ける問題なのよ。。
### DFS
```java
class Solution {
  public int numIslands(char[][] grid) {
    int numIslands = 0;
    // 全探索
    for (int i = 0 ; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        // 島を発見
        if (grid[i][j] == '1') {
          numIslands += 1;
          dfs(grid, i, j);
        }
      }
    }

    return numIslands;
  }

  // 島があったら海に変更するだけの再帰関数(木構造に対する再帰関数の使い方とはだいぶ違うね)
  private void dfs(char[][] grid, int x, int y) {
    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
      return;
    }
    if (grid[x][y] != '1') return;

    grid[x][y] = '0';
    // 上下左右に dfs をかけ、隣接する島を海へ変更する
    dfs(grid, x - 1, y); // top
    dfs(grid, x + 1, y); // bottom
    dfs(grid, x, y - 1); // left
    dfs(grid, x, y + 1); // right
  }
}
```

## 3rd

## 4th

## 5th
