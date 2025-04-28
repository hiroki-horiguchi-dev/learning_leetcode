## 1st
- Tree が与えられるので、depth 毎の `node.val` を二次元リストに入れて返却せよって問題
- 再帰より BFS の方が depth をインクリメントするだけでいいので良さそうだと思う
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;

        // BFS が最も楽
        // depth ごとに ArrayList につめていくのが一番いいね
        // バケットソート的な発想をしていけば間違い無いかな
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> temp = queue.poll();
            TreeNode currentNode = temp.getKey();
            int currentLevel = temp.getValue();

            // 新しいレベル用のリストがなければ作る
            if (currentLevel == levels.size()) {
                levels.add(new ArrayList<>());
            }

            levels.get(currentLevel).add(currentNode.val);

            if (currentNode.left != null) {
                queue.add(new Pair(currentNode.left, currentLevel + 1));
            }

            if (currentNode.right != null ) {
                queue.add(new Pair(currentNode.right, currentLevel + 1));
            }
        }

        return levels;
    }
}
```
- 時間計算量
  - 全要素探索なので、tree.size に依存する、n とするので O(N)
- 空間計算量
  - Queue に詰める際にメモリ使うので、tree.size に依存して O(N)

## 2nd

## 3rd

## 4th

## 5th
