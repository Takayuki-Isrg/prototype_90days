# E2E Test Artifact設計

## 方針
- AfterEachで処理する
- テスト失敗時のみ保存
- 保存先：build/artifacts
- ファイル名：テスト名 + 日時
