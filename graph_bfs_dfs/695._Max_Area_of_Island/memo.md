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
- 空間計算量

### BFS (breadth-first search)
```java

```
- 時間計算量
- 空間計算量


## 2nd

## 3rd

## 4th

## 5th
