package com.takayuki.qe;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Files;
import java.nio.file.Path;

public abstract class TestBase {
  protected Playwright playwright;
  protected Browser browser;
  protected BrowserContext context;
  protected Page page;

  @BeforeEach
  void setUp() throws Exception {
    playwright = Playwright.create();
    browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false)); // falseにするとブラウザを起動してテストを実行する
    context = browser.newContext();
    page = context.newPage();

    // 失敗時に備えて保存先だけ作る
    Files.createDirectories(Path.of("build/artifacts"));
  }

  @AfterEach
  void tearDown() {
    try {
      // build/artifacts/配下にlast.pngを保存する
      if (page != null) {
        page.screenshot(new Page.ScreenshotOptions()
            .setPath(Path.of("build/artifacts/last.png"))
            .setFullPage(true));
      }
    } catch (Exception ignored) {
      // スクショ失敗は無視（本題ではない）
    } finally {
      if (context != null)
        context.close();
      if (browser != null)
        browser.close();
      if (playwright != null)
        playwright.close();
    }
  }
}