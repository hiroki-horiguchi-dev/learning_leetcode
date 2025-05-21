## 1st
- 
- 方針
  - wordDict を線形探索しながら、先頭文字に合致するものがあるか探索する
  - あれば、その文字分 s の index をずらして再度先頭文字に合致するものがあるか探索する
  - なければ false 投げて終わり
  - Ex.1
    - ![img.png](img.png)
  - Ex.2
    - ![img_1.png](img_1.png)
  - 計算回数も `wordDict.size() = n` とすると、時間計算量は `O(N)` を再帰で積む回数分で定数無視できるから、O(N) と考えた
  - 上記の全探索(DFS)方針で chatGpt に投げてみたけど、なるほど、このテストケースだと無駄な計算が増えるねえ
    - `s = "aaaaaaaaaaaaaaaaaaaaaab"
        wordDict = ["a", "aa", "aaa", ..., "aaaaa"]` 
    - → 「b」だけがマッチしないとき、
    - → 「a」から始めて何度も再帰呼び出しして「b」に辿り着いて失敗、を何回も繰り返すことになる
  - じゃあどうする？
    - [300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/description/) の二重ループの方針と似ている
    - ![img_2.png](img_2.png)
    - ![img_3.png](img_3.png)
    - ![img_4.png](img_4.png)
    - s.length が最大でも 300 なので、O(N^2) になってもたかだか 1000回くらいの計算量で済む
    - 復習
      - 問題 Ex2 のケース
        - ![img_5.png](img_5.png)
        - ![img_6.png](img_6.png)
        - ![img_8.png](img_8.png)
        - ![img_7.png](img_7.png)
        - ![img_9.png](img_9.png)
        - ![img_10.png](img_10.png)
      - 異常系
        - ![img_11.png](img_11.png)
        - ![img_12.png](img_12.png)
        - ![img_13.png](img_13.png)
    
```java
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // https://docs.oracle.com/javase/jp/8/docs/api/java/util/HashSet.html#HashSet-java.util.Collection-
        // list contains は O(N), set contains は O(1) なので set
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
```

## 2nd
- 5/22 8:40 ~ 8:53
- 方針
  - 計算量的に許される O(N^2) で解いた
  - 初回に解いてから時間が空いていないので `dp[0] = true` を忘れずに記載したが、本番ではこういうところが穴になりそうで怖め。。 
```java
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // s.length が 10^3 なので O(N^2) までの計算量で解けば TLE しなそう
        // i, j の二重ループで dp を作る
        // ① HashSet の作成, collections をコンストラクタに取るので、これで Set が作成できる
        Set<String> set = new HashSet<>(wordDict);
        boolean[] isConsist = new boolean[s.length() + 1];
        isConsist[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // ① wordDict の走査が必要、List のままだと O(N) かかるので、Set に格納して検索させる
                if (set.contains(s.substring(j, i)) && isConsist[j]) {
                    isConsist[i] = true;
                    break;
                }
            }
        }

        return isConsist[s.length()];
    }
}
```
## 3rd

## 4th

## 5th
