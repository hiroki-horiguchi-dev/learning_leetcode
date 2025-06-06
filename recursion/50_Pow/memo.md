## 1st
- 引数 x の累乗(引数 n) を求める問題
- 方針
  - n が整数なので、どちらも考慮しなければいけないのが面倒臭いところ
  - for で回してもいいんだが、再帰関数の学習範囲っぽいので再帰でかく
```java
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n > 0) {
            return x * myPow(x, n - 1);
        } else {
            return 1/x * myPow(x, n + 1);
        }
    }
}
```
- サッと雑に書いて手元のテストケース通ったから submit したら n が最大 2^31 - 1 まであるケースで TLE したので再度考え直す
- `2^31 == 10^9` なので、計算回数を半分にしてやれば一秒内で計算が終わる
- なんかきっと、BS みたいに計算すればいいんだと思うんだけど思いつかなかった。。。
```java
class Solution {
    public double myPow(double x, int n) {
        long n = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    // n = 0 return 1
    // n = 1 return 1 * 1 * 2 = 2
    // n = 2 return 2 * 2 = 4
    // n = 5 return 4 * 4 * 2 = 32
    // n = 10 return 32 * 32 = 1024
    private double fastPow(double x, long n) {
        if (n == 0) return 1;
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
```
## 2nd

## 3rd

## 4th

## 5th
