## 1st
- 方針
  - 線形走査か、BSじゃないと詰む
  - left, right ポインタを用意してサブアレイを走査してあげれば良さそう
  - 累積和を使えば良さそう
```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, prefixSum = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < nums.length) {
            prefixSum += nums[right];
            if (prefixSum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                left++;
                right = left;
                prefixSum = 0;
            } else {
                right++;
            }
        }

        if (minLen == Integer.MAX_VALUE) return 0;
        else return minLen;
    }
}
```
- 解けたけど、、計算量が最悪 O(N^2) になってしまうのであまりよろしくはない
- sliding window の考え方がまるで身についてない
- 方針2
  - chatGpt が履いてくれた O(N) で済むプログラム
  - 以下から分かるように、今回の問題で sliding window を使うと条件に合致した場合に left 要素を引いて無かったことにし、そのまま right を進めることだとわかる
  - 重要なのは、計算効率のために left を捨てるような考え方をすること
  - どちらの問題も subarray なので subArray に特化した手法なのかな？
```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
```

## 2nd

## 3rd

## 4th

## 5th
