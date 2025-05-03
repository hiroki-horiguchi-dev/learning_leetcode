## 1st
- 二つの tree が与えられるので、マージ(ここでは和で)する
- イージーっぽいのでサクッと回答プログラム組んだ
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) return null;

        int newValue = 0;

        if (root1 != null) {
            newValue += root1.val;
        }

        if (root2 != null) {
            newValue += root2.val;
        }

        TreeNode node = new TreeNode(newValue);

        node.left = mergeTrees(
            root1 != null ? root1.left : null,
            root2 != null ? root2.left : null
        );
        node.right = mergeTrees(
            root1 != null ? root1.right : null,
            root2 != null ? root2.right : null
        );

        return node;
    }
}
```
- 計算量
  - ` O(N)`
- 空間計算量
  - ` O(N)`
- どちらともroot1,2 のサイズが大きい方が律速する 

### BFS
- Queue を 3つ用意する
- 2つで十分かと思っていたけど、3つ必要なのか。。。
  - 頭のリソース使いがちなので明日に回す
```java
public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null) return root2;
    if (root2 == null) return root1;

    TreeNode mergedRoot = new TreeNode(root1.val + root2.val);
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<TreeNode> queue1 = new LinkedList<>();
    Queue<TreeNode> queue2 = new LinkedList<>();

    queue.add(mergedRoot);
    queue1.add(root1);
    queue2.add(root2);

    while (!queue1.isEmpty() && !queue2.isEmpty()) {
        TreeNode current = queue.poll();
        TreeNode node1 = queue1.poll();
        TreeNode node2 = queue2.poll();

        // left 子ノードの処理
        TreeNode left1 = node1.left;
        TreeNode left2 = node2.left;
        if (left1 != null || left2 != null) {
            if (left1 != null && left2 != null) {
                TreeNode leftMerged = new TreeNode(left1.val + left2.val);
                current.left = leftMerged;
                queue.add(leftMerged);
                queue1.add(left1);
                queue2.add(left2);
            } else {
                current.left = (left1 != null) ? left1 : left2;
            }
        }

        // right 子ノードの処理（同様に）
        TreeNode right1 = node1.right;
        TreeNode right2 = node2.right;
        if (right1 != null || right2 != null) {
            if (right1 != null && right2 != null) {
                TreeNode rightMerged = new TreeNode(right1.val + right2.val);
                current.right = rightMerged;
                queue.add(rightMerged);
                queue1.add(right1);
                queue2.add(right2);
            } else {
                current.right = (right1 != null) ? right1 : right2;
            }
        }
    }

    return mergedRoot;
}
```

## 2nd
- 再帰関数でやる方が楽そうやなあと思うので再帰でやってみたけど、BFS もとりあえず形は追ってみたので 1st へ記載
### DFS
- 三項演算子の部分忘れがちなことに注意
- Ex1 の input1 について、root1 の左端 leaf node 5 と roo2 の左端 leaf node null で 5 を作ったあと、
- root2.left, right にアクセスするときに root2 自体が null なのでヌルぽになるよ
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        /// DFS でやるなら root 作って left, right 構築かな
        if (root1 == null && root2 == null) return null;

        int newValue = 0;

        if (root1 != null) {
            newValue += root1.val;
        }

        if (root2 != null) {
            newValue += root2.val;
        }

        TreeNode root = new TreeNode(newValue);

        root.left = mergeTrees(
            root1 != null ? root1.left : null, 
            root2 != null ? root2.left : null
        ); 
        root.right = mergeTrees(
            root1 != null ? root1.right : null, 
            root2 != null ? root2.right : null
        );

        return root;
    }
}

// こっちでもいいよな、こっちの方がシンプルだな
public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
  if (root1 == null) return root2;
  if (root2 == null) return root1;

  TreeNode root = new TreeNode(root1.val + root2.val);
  root.left = mergeTrees(root1.left, root2.left);
  root.right = mergeTrees(root1.right, root2.right);
  return root;
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 構築系で DFS がベスト
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode root = new TreeNode(root1.val + root2.val);

        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);

        return root;
    }
}
```
- BFS でもできないことはないんだろうが、かなり手間だと思うので省略
## 4th

## 5th
