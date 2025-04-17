## 1st
- String をソートするところで char[] に変換して Arrays に渡すところがちょっと甘かったかな。。
- それ以外はほぼ方針通り、実装も問題なし
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 回答用二次元配列の作成
        ArrayList<List<String>> result = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (map.containsKey(sorted)) {
                map.get(sorted).add(str);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(sorted, temp);
            }
        }

        for (List<String> temp : map.values()) {
            result.add(temp);
        }

        return result;
    }
}
```
## 2nd

## 3rd

## 4th

## 5th
