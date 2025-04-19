## 1st
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length ; i++) {
            int num = nums[i];
            int complement = target - num;

            if (map.containsKey(complement)) {
                result[0] = map.get(complement);
                result[1] = i;
                break;
            }

            map.put(nums[i], i);
        }
        return result;
    }
}
```
- chatgpt にざっくりした方針を尋ねながらかいた
- `complement` を key にする方針で AC したけど、重複する可能性があるので絶対NG
- 今回のように complement は別で計算し、これを map が持つかどうか？でループを回すべき
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            // hashmap には nums の要素とインデックスを保存
            // index を key, value に要素にしないと重複する可能性があるか？
            // --> you may not use the same element twice. と書いてるので nums[i] を index として良い

            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                result[0] = map.get(complement);
                result[1] = i;
                break;
            }

            map.put(nums[i], i);
        }

        return result;
    }
}
```
- これで完璧かな

## 2nd

## 3rd

## 4th

## 5th
