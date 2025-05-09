## 1st
- バイナリツリーの root が与えられるので、最も浅い数を返却する
- 方針
  - DFS
    - リーフに辿り着くまで、行ける方だけ深さを数えていく
    - input2 のように片方だけノードを持つ枝がある場合の対処が厄介
    `Input: root = [2,null,3,null,4,null,5,null,6]`
    2
      \
        3
          \
            4
              \
                5
                  \
                    6
  - BFS
    - たどっていって存在していれば queue につめるだけ
    - こっちの方がわかりやすくて楽かもしれないね


### DFS
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
    public int minDepth(TreeNode root) {
        if (root == null) {
        return 0;
        }

        // リーフノードなら深さは1
        if (root.left == null && root.right == null) {
            return 1;
        }

        // 左の子がない場合、右側だけ再帰
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        // 右の子がない場合、左側だけ再帰
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        // 両方ある場合は、左右の最小深度に1を足す
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
```
- 時間計算量
  - `O(N)`
  - Tree の全要素にアクセスするから
- 空間計算量
  - スタックに再帰関数が呼ばれる数分積まれる
  - tree の高さを h として、`O(h)`

### BFS
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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> current = queue.poll();
            TreeNode node = current.getKey();
            int currentDepth = current.getValue();

            if (node.left == null && node.right == null) {
                return currentDepth;
            }

            if (node.left != null) {
                queue.add(new Pair<>(node.left, currentDepth + 1));
            }

            if (node.right != null) {
                queue.add(new Pair<>(node.right, currentDepth + 1));
            }
        }

        return 0;
    }

    // leetcode では Pair 使えるみたいだけど、もし使えなきゃ自作しちゃえばおk
    class Pair<TreeNode, Integer> {
        TreeNode node;
        Integer num;

        Pair(TreeNode node, Integer num) {
            this.node = node;
            this.num  = num;
        }
        
        TreeNode getKey() {
            return this.node;
        }

        Integer getValue() {
            return this.num;
        }
    }
}
```
- 時間計算量
  - `O(N)`
- 空間計算量
  - `O(N)`

## 2nd
### DFS + 再帰
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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        // 片方の子を持つ枝ノード
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        // 両方の子を持つ枝ノード
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
```
### BFS
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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<NodeDepth> queue = new LinkedList<>();
        queue.add(new NodeDepth(root, 1));

        while (!queue.isEmpty()) {
            NodeDepth nodeDepth = queue.poll();
            TreeNode currentNode = nodeDepth.getCurrentNode();
            int currentDepth = nodeDepth.getCurrentNodeDepth();

            // ここは return の方が BFS の本質に近い
            if (currentNode.left == null && currentNode.right == null) {
                return currentDepth;
            }

            if (currentNode.left != null) {
                queue.add(
                    new NodeDepth(
                        currentNode.left,
                        currentDepth + 1
                    )
                );
            }

            if (currentNode.right != null) {
                queue.add(
                    new NodeDepth(
                        currentNode.right,
                        currentDepth + 1
                    )
                );
            }
        }

        return 0;
    }

    class NodeDepth {
        private TreeNode node;
        private int currentDepth;
        NodeDepth(TreeNode node, int currentDepth) {
            this.node = node;
            this.currentDepth = currentDepth;
        }

        TreeNode getCurrentNode() {
            return this.node;
        }

        int getCurrentNodeDepth() {
            return this.currentDepth;
        }
    }
}
```
## 3rd
- DFS 10分
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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        // leaf node
        if (root.left == null && root.right == null) {
            return 1;
        }

        // 右に子を持つ可能性がある
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        // 左に子を持つ可能性がある
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        // 両方に子を持つ
        return Math.min(
                minDepth(root.left) + 1,
                minDepth(root.right) + 1
        );
        
    }
}
```

- BFS
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
    public int minDepth(TreeNode root) {
        // BFS
        // leaf node に到達した瞬間に return

        if (root == null) return 0;

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 1));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            Integer level = pair.getValue();

            // leaf node を発見
            if (node.left == null && node.right == null) {
                return level;
            }

            if (node.left != null) {
                queue.add(new Pair(node.left, level + 1));
            }

            if (node.right != null) {
                queue.add(new Pair(node.right, level + 1));
            }
        }

        // 文法上
        return 0;
    }
}
```

## 4th

## 5th
