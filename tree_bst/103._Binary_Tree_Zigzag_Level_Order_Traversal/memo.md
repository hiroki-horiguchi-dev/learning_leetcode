## 1st
- Tree が与えられるので、depth 毎の `node.val` を二次元リストに入れて返却せよって問題
- ただし、奇数レベルにおいては逆順にする必要がありまっせ
- 102 と同様に、再帰より BFS の方が depth をインクリメントするだけでいいので良さそうだと思う
- 再帰でやる方法は適さない気がする
    - 特に depth ごとに List にまとめるのが再帰だと面倒臭そう
- BFS で二次元リストに depth ごとに入れていく処理はバケットソート的なやり方をすれば良いと考えた
    - そのため、Queue に入れる depth に該当する数字の初期値が 0 スタートになっていることが注意点かな

### BFS
- Queue に各ノードとその深さを Pair でいれてたどっていくイメージで実装
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // いったん全てカウントして、奇数レベルだけ Collections で逆ソートする？
        // いや、add するときに最後に詰めるか最初に詰めるか場合分けすれば良い

        List<List<Integer>> zigzagLevel = new ArrayList<>();
        if (root == null) return zigzagLevel;

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> currentPair = queue.poll();
            TreeNode currentNode = currentPair.getKey();
            int currentLevel = currentPair.getValue();

            if (zigzagLevel.size() == currentLevel) {
                zigzagLevel.add(new ArrayList<Integer>());
            }

            if (currentLevel % 2 == 0) {
                // 偶数
                zigzagLevel.get(currentLevel).add(currentNode.val);
            } else {
                zigzagLevel.get(currentLevel).add(0, currentNode.val);
            }

            if (currentNode.left != null) {
                queue.add(new Pair(currentNode.left, currentLevel + 1));
            }

            if (currentNode.right != null) {
                queue.add(new Pair(currentNode.right, currentLevel + 1));
            }
        }

        return zigzagLevel;
    }
}
```
- 時間計算量
    - 102と同様に全要素探索なので、tree.size に依存する、n とするので O(N)
- 空間計算量
    - 102と同様に Queue に詰める際にメモリ使うので、tree.size に依存して O(N)

## 2nd

## 3rd

## 4th

## 5th
