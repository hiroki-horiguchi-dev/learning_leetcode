## 1st
- 文字列が与えられるので、その中の最初に出現した、かつユニークな文字のインデックスを返せ
- まず思いついて書いてみたのはこれ
```java
class Solution {
    public int firstUniqChar(String s) {
        int result = -1;
        /// HashMap[[l,[0,1]], [e,[1,3]]...[d,[6,1]]] みたいなやつ作る
        /// int 配列だと分かりづらいんだよなあ。。
        LinkedHashMap<Character, int[]> hashMap = new LinkedHashMap<>();

        for (int index = 0; index < s.length(); index++) {
            char key = s.charAt(index);
            if (hashMap.containsKey(key)) {
                int[] temp = hashMap.get(key);
                temp[1] = temp[1] + 1;
                hashMap.put(key, temp);
            } else {
                int[] frequencyIndex = new int[2];
                frequencyIndex[0] = index;
                frequencyIndex[1] = 1;
                hashMap.put(key, frequencyIndex);
            }
        }

        for (int[] values : hashMap.values()) {
            if (values[1] == 1) {
                result = values[0];
                break;
            }
        }

        return result;
    }
}
```
- かなり分かりづらい
  - 特に int[] で index と出現回数を保持しているところ、これやるなら別途データクラスみたいなやつ作った方がいい
  - `LinkedHashMap` っていう使い慣れないクラスを使っているところ
- 時間計算量
  - 2回の走査なので O(N)
- 空間計算量
  - `LinkedHashMap` 作成で Character は 26文字、と int[2] * 26 しか使わないので、O(1)
- もっと分かりやすく書けるやろ、ということで方針を考える
- 最初に hashMap に英単語と重複数を保存して、その後また文字列の先頭から走査して重複回数が 1 なら返却で良いやんけ
- この方針がすぐ思いつかない時点で疲れているので今日はこれで終わり
```java
class Solution {
    public int firstUniqChar(String s) {
        /// -1 は仕様
        int result = -1;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        /// String は Iterable じゃないから拡張for使えないんやった
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.get(c) == 1) {
                result = i;
                break;
            }
        }

        return result;
    }
}
```
- 時間計算量
  - 変わらず O(N)
- 空間計算量
  - 変わらず O(1)


## 2nd

## 3rd

## 4th

## 5th
