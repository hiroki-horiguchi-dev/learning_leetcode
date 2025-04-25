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
## 2nd

## 3rd

## 4th

## 5th
