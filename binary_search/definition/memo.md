# Binary Search
- これはまあ知ってる斜め読みのまとめでいいかな。。
- 線形探索より優れているよねってお話
- 擬似コード
```
BinarySearch(A, b) {
    if (A の長さが 0) return false;
    else if (A[n/2] = b) return true;
    else if (A[n/2] b) {
        return BinarySearch(A[0..n/2 - 1], b); // Aの前半
    } else return BinarySearch(A[n/2 + 1 ... n - 1], b) // Aの後半
}
```
- もうバイナリーサーチっぽいやつはここでやっている
  - [tree_bst/108._Convert_Sorted_Array_to_Binary_Search_Tree/memo.md](https://github.com/hiroki-horiguchi-dev/learning_leetcode/blob/0e1485fd84d15456a0a4e38acce73689dd8d847e/tree_bst/108._Convert_Sorted_Array_to_Binary_Search_Tree/memo.md)
- ⚠️注意⚠️
  - このアルゴリズムが効率よく動くためには A をどのように表現するかが重要
  - ここでは単に与えられた位置の要素や部分列を長さによらない定数時間で取り出せるものと仮定する
- 時間計算量のお話
  - `O(nlogn)` で済むよねってお話