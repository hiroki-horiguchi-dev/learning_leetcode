## 1st
- [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)
- 問題
  - 株価を与えるからどの地点で買い売りを一回すれば最大の利益が得られるか？
  - その利益を返せ
- 方針 
![img.png](img.png)
```java
class Solution {
    public int maxProfit(int[] prices) {
        int min  = prices[0];
        int max  = 0;

        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - min;
            min = Math.min(min, prices[i]);
            max = Math.max(max, diff);
        }
        return max;
    }
}
```
- 時間計算量
  - `O(N)`
- 空間計算量
  - `O(1)`

## 2nd
- 5/22 8:25 ~ 
- 方針
  - easy なのにわからなくなってギブアップ。。。
  - なんでこの方針がパッと思いつかないのか、、偶然パフォーマンス下振れしたか？
```java
class Solution {
    public int maxProfit(int[] prices) {
        // prices.length が 10^5 なので、線形走査で終わらせないと TLE
        // max の更新処理をひたすらしていけば良さそう
        // 知りたいのは min がどこと、線形走査しているときの差が最も大きい値

        int max = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - min;
            max = Math.max(max, diff);
            min = Math.min(min, prices[i]);
        }

        return max;
    }
}
```

## 3rd

## 4th

## 5th
