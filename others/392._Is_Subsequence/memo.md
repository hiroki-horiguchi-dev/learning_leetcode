## 1st
- 問題
    - `392. Is Subsequence`
    - 文字列 s, t が与えられる
    - s が t の subsequence の場合は true, それ以外は false を返す
    - `subsequence` とは
      - s の先頭文字から末尾までが順序を守った状態で t に含まれる文字列のこと
      - 順序を無視した subset のような集合とは異なる
- 方針
  - for の二重ループのような探索が向いていない
  - while を使ったポインター探索が最もベスト
  - 計算量は s が最大100文字、t が最大 10^4 文字で単一ループを使うので、O(N)
  - 最悪計算量は 10^4 max t.length - 10^4 のため
    - Constraints:
        - `0 <= s.length <= 100`
        - `0 <= t.length <= 10^4`
        - `s and t consist only of lowercase English letters.`
- 実装
```java
class Solution {
    public boolean isSubsequence(String s, String t) {
        // for だと壊滅的に subsequence の走査に向いてないので while を使う
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}
```

## 2nd

## 3rd

## 4th

## 5th
