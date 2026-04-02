package com.takayuki.qe.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;

    // Sauce Demo selectors
    private final String username = "#user-name";
    private final String password = "#password";
    private final String loginButton = "#login-button";

    private final Locator errorMessage;

    public LoginPage(Page page) {
        this.page = page;
        this.errorMessage = page.locator("[data-test='error']");
    }

    public void open() {
        page.navigate("https://www.saucedemo.com/");
    }

    public void login(String user, String pass) {
        page.locator(username).fill(user);
        page.locator(password).fill(pass);
        page.locator(loginButton).click();
    }

    public boolean isErrorDisplayed(){
        return errorMessage.isVisible();
    }
    
    public String getErrorMessage() {
        return errorMessage.textContent();
    }
    
    public boolean hasErrorMessage(String expected){
        return errorMessage.textContent().contains(expected);
    }
}