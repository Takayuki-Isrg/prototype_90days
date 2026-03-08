package com.takayuki.qe.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;

    // Sauce Demo selectors
    private final String username = "#user-name";
    private final String password = "#password";
    private final String loginButton = "#login-button";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void open() {
        page.navigate("https://www.saucedemo.com/");
    }

    public void login(String user, String pass) {
        page.locator(username).fill(user);
        // page.setDefaultTimeout(3000); // 3秒でタイムアウト
        // page.locator(password).fill(pass);
        page.locator("#password-xxx").fill(pass); // 異常テスト用
        page.locator(loginButton).click();
    }
}