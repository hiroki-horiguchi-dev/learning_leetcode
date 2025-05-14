## 1st
- [322. Coin Change](https://leetcode.com/problems/coin-change/description/)
- ![img.png](img.png)
- target を満たすコインの和の組み合わせ最小値を求めて返却する問題
  - 方針
    - `[11 - 1, 11 - 2, 11 - 5]` のように amount からそれぞれのコインの数を引いたものをリストとして作り、
    - 0 になったら即終了という DFS の発想で組もうと思ったが。。
    - wordBreak の時の `[aaaaaaaaaaaab], [a,aa,aaa,aaaa]` の時と同様に b に辿り着くまでに異常な数の計算をしないといけないため確実に TLE する
    - 同様の例を考えてみると、`coins = [1,1,1,1,1,1,1,1,1,1,1], amount = 10^4` の時、無駄な計算処理が走りまくるのはよろしくない
  - じゃあどうする？
    - dp 的発想の、すでに出た金額の答えを保存する
    - dp を dp[i] = i 円を作るまでの最小コイン数として記録していく
```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // i - coin >= 0 は、dp[] の index out of bound を防ぐため
                // dp[i - coin] != Integer.MAX_VALUE は、そもそも i - coin 円を構成する最小枚数が記録されているかどうかの確認するため
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    // Math.min を初見で入れるのは絵を描いてからじゃないと無理かな。。
                    // i - coin の発想に至るまでに1ステップ必要
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}
```
- 時間計算量
  - dp[i]円を構成する最小枚数で考えると、`O(coins.length * amount)` になる
- 空間計算量
  - `O(amount)`

## 2nd

## 3rd

## 4th

## 5th
