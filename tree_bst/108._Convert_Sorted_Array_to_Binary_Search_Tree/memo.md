## 1st
- 2つの TreeNode が与えられるので、これらをマージして新しい value を持つ Tree を作成し返却せよ
- 方針
  - 再帰関数で与えられた int[] nums を操作していくのが一番わかりやすいと感じる
  - 常に middle を計算し、nums と start, end インデックスを渡して left, right を構築していくイメージ

### DFS(再帰)
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {
        if (start >= end) return null;
        
        // オーバーフロー回避
        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBSTHelper(nums, start, mid);
        root.right = sortedArrayToBSTHelper(nums, mid + 1, end);

        return root;
    }
}
```

## 2nd
- 構築系なので DFS
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
    public TreeNode sortedArrayToBST(int[] nums) {
        // 構築系なのでまたしても DFS がベストと考える
        return sortedArrayToBSTHelper(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {

        if (start >= end) return null;

        int middle = start + (end - start) / 2;

        TreeNode root = new TreeNode(nums[middle]);

        root.left  = sortedArrayToBSTHelper(nums, start, middle);
        root.right = sortedArrayToBSTHelper(nums, middle + 1, end);

        return root;
    }
}
```

## 3rd

## 4th

## 5th
