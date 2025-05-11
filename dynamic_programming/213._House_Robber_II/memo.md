## 1st
- [213. House Robber II](https://leetcode.com/problems/house-robber-ii/description/)
- ![img.png](img.png)
- house Robber I の最初の家と最後の家がつながっている問題
- とはいえ、dp 使ってそれまでの最大和を保持する方針は使えそう
- 終点だけ別処理にすれば良さそう？
  - ![img_1.png](img_1.png)
  - この発想でなんとなくあっていて、dp を2つ構築すれば良い
```java
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        // ex. 1,2,3,4,5,6
        
        // 1.2,3,4,5
        int[] excludeLastDp = new int[nums.length - 1];
        excludeLastDp[0] = nums[0];
        excludeLastDp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length - 1; i++) {
            excludeLastDp[i] = Math.max(excludeLastDp[i-1], excludeLastDp[i-2] + nums[i]);
        }

        // 2,3,4,5,6
        int[] excludeFirstDp = new int[nums.length - 1];
        excludeFirstDp[0] = nums[1];
        excludeFirstDp[1] = Math.max(nums[1], nums[2]);

        for (int i = 2, j = 3; j < nums.length; i++, j++) {
            excludeFirstDp[i] = Math.max(excludeFirstDp[i-1], excludeFirstDp[i-2] + nums[j]);
        }

        return Math.max(excludeLastDp[excludeLastDp.length - 1], excludeFirstDp[excludeFirstDp.length - 1]);
    }
}
```
- 通ったけど次回綺麗にしたい
  - 同じような rob 処理をやっているところを別関数として切り出したい
  - dp[] 配列を無理に使わずに、previous, current に分けてそっちに保存するようにしたいな

- 時間計算量
  - `O(N)`
- 空間計算量
  - `O(N)`

## 2nd

## 3rd

## 4th

## 5th
