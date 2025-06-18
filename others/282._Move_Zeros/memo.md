## 1st
- 問題
  - Move Zeros
  - `int[] nums = [1,2,3,0,5,6,7,0,10,14,0]`
  - が、例えば与えられるから 0 を省いて以下のような形にせよ
  - `int[] nums = [1,2,3,5,6,7,10,14,0,0,0]`
- 方針
  - 線形探索で終わらせたい
  - Arraylist の remove, add みたいな処理を int[] に対してできれば完了
  - int[] は固定長なので、インデックスを指定して要素を**上書き**することで代替できる
  - だから、i 番目を書き換えるみたいな処理で回す
- 実装
```java
class Solution {
    public void moveZeroes(int[] nums) {
        // やるなら線形走査が一番楽かな
        // 計算量も nums.length = 10^4 なので余裕で終わる
        // 線形走査以上の計算速度を出したいなら、BS っぽくやる以外にないけど、結局全探索することになるから O(N) と変わらんだろ
        int insertPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPosition] = nums[i];
                insertPosition++;
            }
        }

        while (insertPosition < nums.length) {
            nums[insertPosition] = 0;
            insertPosition++;
        }
    }
}
```
## 2nd

## 3rd

## 4th

## 5th
