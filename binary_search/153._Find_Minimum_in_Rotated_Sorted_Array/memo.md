## 1st
- [153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
- ![img_1.png](img_1.png)
- k 回ローテションされた昇順ソート済み配列から最小値を見つける問題
- 方針
  - start, middle, end を用意
  - nums[middle], nums[end] を比較して nums[middle] の方が大きければ middle ~ end,
  - そうでなければ start ~ middle に最小値が存在する
  - ![img_2.png](img_2.png)
  - どの区間を探索するのか？を考えれば難しくない
  - ⚠️文字列の substring の時と index 管理が違うので、ん？ん？あれ？ってなってしまった
```java
class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end   = nums.length - 1;

        while (start < end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] > nums[end]) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }

        return nums[start];
    }
}
```
## 2nd

## 3rd

## 4th

## 5th
