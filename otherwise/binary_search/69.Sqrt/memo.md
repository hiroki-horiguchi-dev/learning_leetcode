## 1st
- 問題
  - 与えられた int の平方根を求める問題
- 制約
  - 与えられる整数は int. 最大で 2^31 - 1
  - 最大値の平方根が大体 46340 くらいなので、ブルートフォースでも 10^4 程度で回し切れるからセーフ
  - BS で start, middle, end を使って O(log n) で解くほうが綺麗かな
- 方針
  1. BS で start, middle, end を使う方針
- 実装
  - 夜やったので30分程度
  - 朝やろうね
```java
class Solution {
    public int mySqrt(int x) {
        // 線形走査かBSか
        // 線形走査だと x の最大値で 10^4 くらいなのでまあ計算量はおっつく
        // BS だと middle 判定でいけるんでまあ速い
        // BS かな
        if (x == 0 || x == 1) return x;
        int start = 1;
        int end = x;
        
        int answer = 0;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            long squrd = (long) middle * middle;
            // middle の二乗が x なら即座に return
            if (squrd == x) return middle;
            // middle の二乗が x を超えるなら、左を探索
            else if (x < squrd) {
                // end を middle - 1 にして探索
                end = middle - 1;
            }
            // middle の二乗が x 未満なら、右探索
            else if (squrd < x) {
                // 今の middle が有力候補
                answer = middle;
                start = middle + 1;
            }
        }

        return answer;
    }
}
```
  
## 2nd

## 3rd

## 4th

## 5th
