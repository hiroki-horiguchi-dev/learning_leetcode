## 1st
- 累積和を使っても解けそうだなあと思ってごにゃごにゃやったけど、解けんので答えを見た
- [kadane's Algorithm](https://en.wikipedia.org/wiki/Maximum_subarray_problem)
- 部分配列の最大和を求めるためのアルゴリズムで有名らしい
- 方針は以下
  - `maxSum` にそれまで出現したサブアレイの最大和を保存するようにする
  - `currentSum(= num[i-1])` と `currentSum(= num[i-1]) + num[i]` のどちらか大きい方を記録する
    - 各位置 i において、`その位置で終わる最大部分配列の和`
    - 累積和っぽく見えるけど、大きい方を選択しているので異なる
  - `maxSum` は今まで見た中での最大の currentSum
```java
class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
```

## 2nd

## 3rd

## 4th

## 5th
