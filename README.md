# 目的

- [60 LeetCode problems to solve for coding interview
](https://medium.com/@koheiarai94/60-leetcode-questions-to-prepare-for-coding-interview-8abbb6af589e) にて紹介されているアルゴリズムの練習を行う

- 全面的にこちらの記事に同意しているので、この方針を2024,2025 で実践してみたい
- [スタートラインに立つためにはどうするのか](https://docs.google.com/presentation/d/1Ny4kmHE2FZMI0AuPxImokweGoAE73RAGivjDJg0kG80/edit#slide=id.p)


# 背景
- Zenn でフォローさせていただいている、[さざんかぬふ](https://zenn.dev/339)さんとお会いする機会があった
- 自分のプログラムを書く速度や新しい技術の習得速度が遅いことに悩んでいたので、どうやったらもっと早くできますかねえ？と質問した
- まずは、先述の60問をやったほうがいいよ、とアドバイスもらったのでやってみることにした
- [この記事](https://zenn.dev/339/scraps/1ce339febdfb22)でも紹介されてます

- 今月、応用情報受けました、非常に勉強になった。
- エンジニア業務に役に立つかと問われると少し微妙だけれど、
自分のやっている**エンジニアとしての業務**(固まった仕様をプログラムする、もちろんそれ以外もやっている)は末端も末端で、その前にネットワークだとかセキュリティだとか、私は先人(会社の先人もそうだし、そもそも発明して実践した先人)の肩に乗せてもらっているだけの存在であることを痛感した。
- 次世代にとっての、先人になれたら非常に嬉しいので頑張りたい

# How
- VSCode 用に leetcode プラグインがあることを発見したのでそちらを使っていく。
- [vscode-leetcode](https://github.com/LeetCode-OpenSource/vscode-leetcode)
- 自分用の[問題進捗管理表](https://docs.google.com/spreadsheets/d/1L5IpC1EY417nYDbwfgHs2CK1ftLPL2q2SIedWrNfA-c/edit?gid=0#gid=0)をまとめています

- 毎日一問以上とく
- 問題を解いた時の手応えの参考は[コーディングの練習方法](https://hayapenguin.com/notes/Posts/2024/04/24/how-to-practice-coding-effectively)にて紹介のあった以下に従う

 ![alt text](/images/image.png)

## 参考図書
- [デ-タ構造とアルゴリズム (新・情報/通信システム工学 TKC-3)](https://amzn.asia/d/bHxCmG6)

## 参考動画
- [離散数学入門](https://www.youtube.com/@hayamizu)
 
# お気持ちまとめスプレッドシート
- 1周目
  - [お気持ち&進捗管理用スプレッドシート](https://docs.google.com/spreadsheets/d/1L5IpC1EY417nYDbwfgHs2CK1ftLPL2q2SIedWrNfA-c/edit?gid=0#gid=0)
- 2周目
  - 1周目が完了したら復習でもう一枚スプシ作って2周目のお気持ちまとめする

# 継続できない時期
 - 進捗が悪くなってきたので以下の本、動画を見てモチベーションを上げています
 - [プログラミングコンテスト攻略のためのアルゴリズムとデータ構造 単行本（ソフトカバー） – 2015/1/30](https://www.amazon.co.jp/dp/4839952957?ref=ppx_yo2ov_dt_b_fed_asin_title)
 - [世界で闘うプログラミング力を鍛える本 ~コーディング面接189問とその解法~ 単行本（ソフトカバー） – 2017/2/27](https://www.amazon.co.jp/gp/product/4839960100/ref=ppx_yo_dt_b_asin_title_o00_s00?ie=UTF8&psc=1)
 - [Leetcodeってどうやって使うの？](https://www.youtube.com/watch?v=I5200JMYLNE)

# それぞれの章ごとに定義をまとめたものをつくろう
- それぞれの章の中に definition ディレクトリ作って各章ごとに定義をまとめよう
  - Why?
    - 例えば再帰関数を使う場合、それが DFS なのか、ただの再帰なのか、問題解いてて頭の中の整理が足りていないなあと思うから
    - 参考書は上述のデータ構造とアルゴリズムを使用する