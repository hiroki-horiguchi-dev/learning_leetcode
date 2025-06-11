## 1st
- 問題
  - ユニークな int 要素を持つ nums 配列が与えられる
  - nums の要素を `rearrange` して、順列を全て返却する問題
- 方針
  - バックトラッキング
  - used, ないし visited のような管理用の boolean 配列を用意
  - nums を線形で走査しつつ、DFS で used を確認して候補を見つけ、また used を確認して使ってない要素を見つけ... というのを nums.length と同じ長さになるまで繰り返す方法
  - 肝になるのは見つけ終わった後に戻る処理、つまりバックトラッキング
  - ループの処理とスタックに積む部分で理解がゴチャゴチャになりがちだが、処理を書き出して以下の表みたいに書くと納得の処理になる
```markdown
1段目: path = []         used = [F, F, F]
├─ i=0 ➝ path=[1]        used=[T, F, F]
│  ├─ i=1 ➝ path=[1,2]   used=[T, T, F]
│  │  ├─ i=2 ➝ path=[1,2,3] ➝ ✅保存
│  │  ⬅ バックトラック ➝ path=[1,2] ➝ used=[T,T,F]
│  │  └─ 次のiなし ➝ 更に戻る
│  └─ i=2 ➝ path=[1,3]   used=[T, F, T]
│     ├─ i=1 ➝ path=[1,3,2] ➝ ✅保存
│     ⬅ バックトラック ➝ path=[1,3] ➝ used=[T,F,T]
│     └─ 次のiなし ➝ 更に戻る
├─ i=1 ➝ path=[2]        used=[F,T,F]
│  ├─ i=0 ➝ path=[2,1]
│  │  ├─ i=2 ➝ path=[2,1,3] ➝ ✅保存
│  └─ i=2 ➝ path=[2,3]
│     ├─ i=0 ➝ path=[2,3,1] ➝ ✅保存
├─ i=2 ➝ path=[3]
│  ├─ i=0 ➝ path=[3,1]
│  │  ├─ i=1 ➝ path=[3,1,2] ➝ ✅保存
│  └─ i=1 ➝ path=[3,2]
│     ├─ i=0 ➝ path=[3,2,1] ➝ ✅保存

```
- 実装
```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, res);
        return res;
    }


    private void backtrack(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));  // 結果に追加（deep copy）
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            path.add(nums[i]);

            backtrack(nums, path, used, res);

            // バックトラック
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
```

## 2nd

## 3rd

## 4th

## 5th
