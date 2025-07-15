## 1st
- 問題
  - [1011. Capacity To Ship Packages Within D Days](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/)
  - input 
    - 昇順ソートされた `int [] weight = [1,2,3,4,5,6,7,8,9,10]`
    - 期限としての `int days`: days 以内に weight を運び切らなければならないという意味の期限
  - 条件
    - `1 <= days <= weights.length <= 5 * 10^4`
    - `1 <= weights[i] <= 500`
- 方針検討
  - 二重ループ回したら即終了なので、BS ないし線形探索を使う
  - プログラム中にコメントしているので、それ読んで
- 実装
```java
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // weight の最大値を capacity min の最小値候補とする
        int start = Arrays.stream(weights).max().getAsInt();;
        // weight の累積和を capacity min の最大値候補とする
        int end   = Arrays.stream(weights).sum();
        int minCapacity   = end;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            boolean isWithinDays = helper(weights, days, middle);
            if (isWithinDays) {
                minCapacity = middle;
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return minCapacity;
    }

    // weights.length 回ループを回して、candidateCapacity を超えるまで積んだら days 更新
    // days 更新したものが、days 以下で収まるなら true, そうでなければ false. 
    private boolean helper(int[] weights, int dayLimit, int candidateCapacity) {
        int dayCount = 1;
        int i = 0;
        int tempSum = 0;
        while (i < weights.length) {
            tempSum += weights[i];
            if (candidateCapacity < tempSum) {
                dayCount++;
                tempSum = 0;
            } else {
                i++;
            }
            if (dayLimit < dayCount) return false;
        }
        // return if () ~ else ~. みたいに書きたいよね
        if (dayCount <= dayLimit) return true;
        else return false;
    }
}
```

## 2nd
## 3rd
## 4th
## 5th