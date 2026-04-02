package com.takayuki.qe;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/**
 * テスト基底クラス
 * 
 */
public abstract class TestBase {
  protected Playwright playwright;
  protected Browser browser;
  protected BrowserContext context;
  protected Page page;

  protected final Path artifactRoot = Path.of("build", "artifacts");
  protected final Path screenshotsDir = artifactRoot.resolve("screenshots"); // テスト失敗時スクショの保存先
  protected final Path videoDir = artifactRoot.resolve("videos"); // テスト失敗時動画の保存先

  @BeforeEach
  void setUp() throws Exception {
    Files.createDirectories(screenshotsDir);
    Files.createDirectories(videoDir);

    playwright = Playwright.create();
    browser = playwright.chromium().launch(
        new BrowserType.LaunchOptions()
            .setHeadless(false));

    context = browser.newContext(
        new Browser.NewContextOptions()
            .setRecordVideoDir(videoDir));

    page = context.newPage();
    page.setDefaultTimeout(3000);
    page.setDefaultNavigationTimeout(10000);
  }

  @AfterEach
  void tearDown() {
    if (context != null) {
      context.close();
    }
    if (browser != null) {
      browser.close();
    }
    if (playwright != null) {
      playwright.close();
    }
  }
}