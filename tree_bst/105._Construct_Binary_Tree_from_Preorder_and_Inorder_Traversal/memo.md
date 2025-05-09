## 目的
- ある二分木における `preorder(行きがけ順)`と`inorder通りがけ順)`が与えられるので、元の二分木を構築しなさい、という問題

## 1st
- 方針
  - left `inorder[0] ~ inorder[preorder[0]]` と 
  - right `inorder[preorder[0] + 1] ~ inorder[inorder.size]` 
  - を start, end インデックスをもとに middle を計算して再帰的に root.left, root.right を構築すれば良い
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);

        int middle = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                middle = i;
                break;
            }
        }

        root.left   = buildTreeHelper(inorder, 0, middle);
        root.right  = buildTreeHelper(inorder, middle + 1, inorder.length);

        return root;
    }

    private TreeNode buildTreeHelper(int[] inorder, int start, int end) {

        if (start >= end) return null;

        int middle = (start + end) / 2;

        TreeNode node = new TreeNode(inorder[middle]);

        node.left = buildTreeHelper(inorder, start, middle);
        node.right = buildTreeHelper(inorder, middle + 1, end);

        return node;
    }
}
```
- Ex の例は AC したが。。。
- 結果、そもそも実装方針が NG でしたって話
  - `preorder` の扱い方が違った
  - `preorder` は、`depth` ごとに Queue につめていくイメージをすればいい
  - `inorder` はイメージが難しいが、
- chatGpt に書かせた以下のコードが良さそう
```java
class Solution {
    private int preorderIndex = 0;  // preorder配列のインデックス管理

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) return null;

        // preorder のインデックスを使って親ノードを取得
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // inorder 配列で親ノードの位置を見つける
        int middle = 0;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == rootValue) {
                middle = i;
                break;
            }
        }

        // 左右の部分木を再帰的に構築
        root.left = buildTreeHelper(preorder, inorder, start, middle - 1);
        root.right = buildTreeHelper(preorder, inorder, middle + 1, end);

        return root;
    }
}

```

## 2nd
- 何も見ずに2回書き直せたが、どうも inorder, preorder は全然味がしないんだよな
- そのために離散数学を覗いたみたりしてみているが、、、解決できるか不明だね。。
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
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int inStart, int inEnd) {

        if (inStart > inEnd) return null;

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        int middle = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (rootValue == inorder[i]) {
                middle = i;
                break;
            }
        }

        root.left = dfs(preorder, inorder, inStart, middle - 1);
        root.right = dfs(preorder, inorder, middle + 1, inEnd);

        return root;
    }
}
```
## 3rd

## 4th

## 5th
