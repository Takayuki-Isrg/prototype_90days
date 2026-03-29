package com.takayuki.qe;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import com.microsoft.playwright.Page;

public class ArtifactWatcher implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Object testInstance = context.getRequiredTestInstance();

        if (!(testInstance instanceof TestBase base)) {
            return;
        }

        try {
            String testName = context.getRequiredTestMethod().getName();
            String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            Path screenshotPath = base.screenshotsDir.resolve(testName + "_" + timestamp + ".png");

            if (base.page != null) {
                base.page.screenshot(new Page.ScreenshotOptions()
                    .setPath(screenshotPath)
                    .setFullPage(true));
            }

            System.out.println("Screenshot saved to: " + screenshotPath);
        } catch (Exception e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
