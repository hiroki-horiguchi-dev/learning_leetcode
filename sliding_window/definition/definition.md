# Sliding Window とは
- [スライディングウィンドウ 【sliding window】](https://e-words.jp/w/%E3%82%B9%E3%83%A9%E3%82%A4%E3%83%87%E3%82%A3%E3%83%B3%E3%82%B0%E3%82%A6%E3%82%A3%E3%83%B3%E3%83%89%E3%82%A6.html#:~:text=%E3%82%B9%E3%83%A9%E3%82%A4%E3%83%87%E3%82%A3%E3%83%B3%E3%82%B0%E3%82%A6%E3%82%A3%E3%83%B3%E3%83%89%E3%82%A6%20%E3%80%90sliding%20window%E3%80%91&text=%E3%82%B9%E3%83%A9%E3%82%A4%E3%83%87%E3%82%A3%E3%83%B3%E3%82%B0%E3%82%A6%E3%82%A3%E3%83%B3%E3%83%89%E3%82%A6%EF%BC%88sliding%20window%EF%BC%89%E3%81%A8,%E3%83%87%E3%83%BC%E3%82%BF%E3%82%92%E9%80%81%E4%BF%A1%E3%81%99%E3%82%8B%E6%96%B9%E5%BC%8F%E3%80%82)
- left, right ポインタを用意して right が条件に違反した場合、即 left = right として窓を開けたり閉めたりするようなものだとイメージした

# 問題
- 3._Longest Substring without repeating characters 
  - 想像と少し違くて、Set はクリアせずに right が条件に違反した場合、left を進めるような方針だった