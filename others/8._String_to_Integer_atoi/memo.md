## 1st
- 問題
    - Ascii To Int 問題
    - 結構前に C 言語で同じようなことをした記憶はある
      - WhiteSapceのスキップ
        - `   123` みたいな場合は ` ` をスキップ
      - 符号判定
        - `-`, `+` を記憶する
        - 主に `-` を記憶する
      - 数字の読み取り
        - 数字 `0 ~ 9` を読み取り続け、途中に数字以外の文字が出てきたらストップ
        - 先頭の 0 は無視して良い
        - `0045abc` の場合、 `45` のみ抜き出す
      - オーバーフロー処理
        - 読み取った整数が 32 ビットを超えている場合は丸める
        - 最小値 `Integer.MIN_VALUE` or 最大値 `Integer.MAX_VALUE`
- 方針
    - 色々とごちゃごちゃやって通るコードはかけたが、明らかに冗長だしおかしいので書き直し
    - DFA(Deterministic Finite Automaton) こと [決定性有限オートマトン](https://ja.wikipedia.org/wiki/%E6%B1%BA%E5%AE%9A%E6%80%A7%E6%9C%89%E9%99%90%E3%82%AA%E3%83%BC%E3%83%88%E3%83%9E%E3%83%88%E3%83%B3) が定石みたい
      - 状態と入力によって次に遷移すべき状態が一意に定まる有限オートマトン
    - これで解くべきだったよう
    - [isDigit](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Character.html#isDigit-char-) 
- 実装
```java
class Solution {
    public int myAtoi(String s) {
        Automaton automaton = new Automaton();
        for (char c : s.toCharArray()) {
            automaton.process(c);
        }
        return (int)(automaton.sign * automaton.result);
    }

    private class Automaton {
        private State state = State.START;
        public int sign = 1;
        public long result = 0;

        enum State {
            START, SIGNED, IN_NUMBER, END
        }

        public void process(char c) {
            switch (state) {
                case START:
                    if (c == ' ') {
                        // 処理なし
                    } else if (c == '+' || c == '-') {
                        sign = (c == '-') ? -1 : 1;
                        state = State.SIGNED;
                    } else if (Character.isDigit(c)) {
                        result = c - '0';
                        state = State.IN_NUMBER;
                    } else {
                        state = State.END;
                    }
                    break;

                case SIGNED:
                    if (Character.isDigit(c)) {
                        result = c - '0';
                        state = State.IN_NUMBER;
                    } else {
                        state = State.END;
                    }
                    break;

                case IN_NUMBER:
                    if (Character.isDigit(c)) {
                        int digit = c - '0';
                        if (result > (Integer.MAX_VALUE - digit) / 10) {
                            result = sign == 1 ? Integer.MAX_VALUE : -(long)Integer.MIN_VALUE;
                            state = State.END;
                        } else {
                            result = result * 10 + digit;
                        }
                    } else {
                        state = State.END;
                    }
                    break;

                case END:
                    // 何もしない
                    break;
            }
        }
    }
}
```
- 感じたこと
  - 今回の決定性有限オートマトンは、以下のような場面に使えると抽象的に解釈しておけば良さそう
  - `連続した input において、いくつかの状態が考えられる`
  - `input に対して線形走査をしながら、特定のinputによって、後続の input 各要素に対する処理を変えないといけない場面で使うのが良さそう`
  - chatGpt は褒めてくれいているが、本当にこれでいいのかはまだ確証が持てない
## 2nd

## 3rd

## 4th

## 5th
