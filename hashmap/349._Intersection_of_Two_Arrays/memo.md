## 1st
- 問題文の intersection の意味がちょっとよくわからなかったが、nums1 と nums2 に重複する要素を返却すればよいと chatgpt が教えてくれた
- 方針は nums1,nums2 の重複要素を排除した Set をそれぞれ作り、2つの Set の積集合を取れば良い
- Java の stream は RxJava でちょっとみたけど書き慣れてないなあ😅
```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1)
                .boxed() // ボクシングしてプリミティブからラッパーへ変換
                .collect(Collectors.toSet());

        Set<Integer> set2 = Arrays.stream(nums2)
                .boxed() // ボクシングしてプリミティブからラッパーへ変換
                .collect(Collectors.toSet());

        // set1 set2 の積集合を取ればいい
        set1.retainAll(set2);
        return set1.stream().mapToInt(Integer::intValue).toArray();
    }
}
```
- あとプリミティブとそれラップしてるクラスと、コレクションと Stream がどういう関係になっているのか全体像を把握したいな
- [IntStream](https://docs.oracle.com/javase/jp/8/docs/api/java/util/stream/IntStream.html)
    - [boxed](https://docs.oracle.com/javase/jp/8/docs/api/java/util/stream/IntStream.html#boxed--)
        - ![img.png](img.png)
        - ![img_1.png](img_1.png)
    - [collect](https://docs.oracle.com/javase/jp/8/docs/api/java/util/stream/IntStream.html#collect-java.util.function.Supplier-java.util.function.ObjIntConsumer-java.util.function.BiConsumer-)
        - ![img_2.png](img_2.png)
    - 積集合
        - [retainAll](https://docs.oracle.com/javase/jp/8/docs/api/java/util/Set.html#retainAll-java.util.Collection-)
            - ![img_3.png](img_3.png)
    - 和集合(もある)
        - [addAll](https://docs.oracle.com/javase/jp/8/docs/api/java/util/Set.html#addAll-java.util.Collection-)
        - ![img_4.png](img_4.png)
    - Stream で操作できるコレクションとかとか
        - https://chatgpt.com/c/6801e502-486c-8009-8cd3-df2b0eff1f57
    - そもそもなんでプリミティブ型とラッパー型に分かれているんだっけ？
        - プリミティブ型は C っぽい感じ int は 4バイト
        - ラッパー型はラッパーなので便利な感じ、16~24バイトくらい
- 時間計算量
  ```markdown
    1. stream で O(N) だよね、boxed は O(1)、collect も stream の流れを汲んでいるので set1,set2 の準備で 2*O(N)
    2. そのあと retainAll で set1 から set2 にないものを削除してる
       set1 に対して set2 を for で回して !set1.contains(set2.value) だったら set1.remove(set2.value)になるから、最悪 set2 の要素N回分 delete が走るので O(N * Setの detele時間) になるかな
       そして最後に set1 を int[] に戻しているのでここで O(N)
    3. 定数無視して、最終的に O(N)
    ```
- 空間計算量
  ```markdown
    1. set1 を用意する際に N = nums1.size とすると O(N)、最悪 O(10^3)
    2. set2 を用意する際に同様に M = nums2.size とすると O(M) 、最悪 O(10^3)
    3. retainAll では set1 への変更のみなので特に不要
    4. 最後の int[] 配列生成時、set1 の要素数 K 個分の Array を作るので O(K), ただし K <= N,M
    5. 厳密には O(M + N + K) になるが、k は M,N と比較すると十分小さいので O(M+N)として良い
  ```
## 2nd

## 3rd

## 4th

## 5th
