## java_playwright
目的：開発寄り品質エンジニアとして「設計→実装→CI」を証明するためのE2E自動化（Java + Playwright）

対象：Sauce Demo（https://www.saucedemo.com/）

実行方法：
```bash
cd java_playwright
mvn test


※ここではCIはまだ書かなくていい。次の週でやる。

---

## 3) docs/strategy.md を追加（10分）
`docs/strategy.md` を新規作成して、まずはこのテンプレを貼るだけ。

```md
# strategy（90日プロトタイプ：QA×開発）

## 目的
- 観点整理→実装の行き来が楽しいか
- コードを書く時間が苦痛かどうか
- 「開発寄り品質（Quality Engineering）」として市場で説明できる芯を作る

## 対象
- Sauce Demo（https://www.saucedemo.com/）

## 今回の自動化範囲（最小）
- ログイン成功（E2E）
- ログイン失敗（後続で追加）

## やらないこと（今は）
- 大規模アプリ化 / API自作
- テスト本数を追うこと
- 毎日やる前提

## 価値の定義（評価軸）
- 「なぜその観点・構造にしたか」を説明できる
- CIで回る（後続で実装）
- 結果が追跡可能（レポート/証跡）

### 2026-02-28
- mvn test 成功
- Timeoutの仕組み理解
- & の意味理解