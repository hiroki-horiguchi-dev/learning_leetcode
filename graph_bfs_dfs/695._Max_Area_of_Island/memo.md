## 1st
- 問題は 200_Number_of_island がとければ余裕でわかる問題
- 島の面積が最大のものを返却せよっていう問題
- 注意点は dfs メソッドを int を返すメソッドにすることくらいかな
```markdown
Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.
```

### DFS (depth-first search)
- さっき解いているので初見で7分くらいかな
- BFS は明日やろう
- chatGpt にはもっとコメントを書けって怒られた、確かにマジックナンバーを置いている箇所はまずいので書き直し
```java
class Solution {
    private int column, row;
    private final int WATER = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        this.column = grid.length;
        this.row = grid[0].length;

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(grid, i, j);
                    max = Math.max(max, count);
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= this.column || y < 0 || y >= this.row || grid[x][y] == WATER) return 0;

        grid[x][y] = WATER;

        // 上下左右探索
        int top = dfs(grid, x - 1, y);
        int down = dfs(grid, x + 1, y);
        int left = dfs(grid, x, y - 1);
        int right = dfs(grid, x, y + 1);

        return top + down + left + right + 1;
    }
}
```
- 時間計算量
  - `O(n * m)`
- 空間計算量
  - `O(n * m)` 再帰関数がスタックに `n*m` 回乗る可能性があるので

### BFS (breadth-first search)
- 初回なので chatGpt に書いてもらった、スタックオーバフローで落ちないのが魅力的とはいえ、やっぱり面倒くさくない BFS ？
```java
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private int column, row;
    private final int WATER = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        this.column = grid.length;
        this.row = grid[0].length;

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[i][j] == 1) {
                    int count = bfs(grid, i, j);
                    max = Math.max(max, count);
                }
            }
        }

        return max;
    }

    private int bfs(int[][] grid, int x, int y) {
        // キューを使ってBFSを行う
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        grid[x][y] = WATER; // 探索済みとして水に変更

        int area = 0;

        // 上下左右の移動方向を定義
        int[] directions = {-1, 0, 1, 0, -1, 0}; // 上, 下, 左, 右

        // BFS開始
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0], cy = current[1];
            area++; // このセルは島の一部なので面積に加算

            // 上下左右の探索
            for (int i = 0; i < 4; i++) {
                int nx = cx + directions[i * 2];
                int ny = cy + directions[i * 2 + 1];

                // グリッドの範囲内かつ、まだ訪れていない島（1）ならQueueに追加
                if (nx >= 0 && nx < column && ny >= 0 && ny < row && grid[nx][ny] == 1) {
                    grid[nx][ny] = WATER; // 訪れたセルを水に変更
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return area;
    }
}
```
- 時間計算量
- 空間計算量


## 2nd

## 3rd

## 4th

## 5th
