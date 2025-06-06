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
- 方針
  - 冪乗を再帰関数で書く方針
  - power となる n が `-2^31 <= n <= 2^31-1` のため、普通に再帰で n 回回すとスタックオーバーフローが発生する
  - そのため、BS っぽく再帰で書く方針を考える
  - 
```java
class Solution {
    public double myPow(double x, int n) {
        // 引数に代入は可読性を考える上であり得ない
        // num^power を考える
        double num = x;
        long power = n;
        if (power < 0) {
            num = 1/num;
            power *= -1;
        }
        return fastPow(num, power);
    }

    private double fastPow(double num, long power) {
        if (power == 0) return 1;
        double exponentiation = fastPow(num, power / 2);

        boolean isEven = (power % 2 == 0);
        if (isEven) {
            return exponentiation * exponentiation;
        } else {
            return exponentiation * exponentiation * num;
        }
    }
}
```
- なんか再帰関数って可読性悪すぎないかねって思うので、どうにかループで書けないか？ということで書いてみた
- 方針
  - ループを回すときに n/2 回回せばいいようにして、変数に保存して冪乗を計算してみる
  - もっと綺麗に簡単に描けると思って30分くらい奮闘したけどダメだったので、 chatGpt に相談の上書いてみたコード
  - うーん、素直に再帰でやった方がいいんかもなあ
```java
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;

        double base = x;
        long power = n;  // 引数はそのままに、コピーだけ変更

        if (power < 0) {
            base = 1 / base;  // 新しい変数 base に変更
            power = -power;
        }

        int maxPower = 0;
        long temp = power;
        while (temp > 0) {
            maxPower++;
            // 実質 temp/2 と同じだけど、演算が早い
            temp >>= 1;
        }

        double[] dp = new double[maxPower];
        dp[0] = base;

        for (int i = 1; i < maxPower; i++) {
            dp[i] = dp[i - 1] * dp[i - 1];
        }

        double result = 1.0;
        for (int i = 0; i < maxPower; i++) {
            // i ビット右にずらして、右端が 1 かどうか判定
            if (((power >> i) & 1) == 1) {
                result *= dp[i];
            }
        }

        return result;
    }
}

```
## 3rd

## 4th

## 5th
