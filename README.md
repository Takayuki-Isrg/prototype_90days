## java_playwright

目的：開発寄り品質エンジニアとして、設計→実装→CI につながる E2E 自動化の最小プロトタイプを作る。  
技術要素：Java / Playwright / Maven / JUnit

対象：Sauce Demo

## 実行方法

```bash
git clone https://github.com/Takayuki-Isrg/prototype_90days.git
cd prototype_90days/java_playwright
```

```powershell
# テスト実行
.\mvnw.cmd clean test

# Playwrightブラウザのインストール
.\mvnw.cmd exec:java "-Dexec.mainClass=com.microsoft.playwright.CLI" "-Dexec.args=install"

# Codegen
.\mvnw.cmd exec:java "-Dexec.mainClass=com.microsoft.playwright.CLI" "-Dexec.args=codegen https://www.saucedemo.com/"
```

```md
## 設計意図
詳細は docs/strategy.md を参照。

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

## ディレクトリ構成
prototype_90days
├ docs/                # 設計メモ・戦略
├ java_playwright/     # PlaywrightによるE2Eテスト
│  └ src/test/java/com/takayuki/qe
│     ├ pages/         # Page Object
│     └ tests/         # テストケース
└ legacy_selenium/     # 旧Selenium実装（Pythonコード、比較用）
```
