package com.takayuki.qe.pages;

import com.microsoft.playwright.Page;

public class InventoryPage {
    private final Page page;

    private final String title = ".title"; // "Products" が表示される

    public InventoryPage(Page page) {
        this.page = page;
    }

    public String getTitleText() {
        return page.locator(title).innerText();
    }
}