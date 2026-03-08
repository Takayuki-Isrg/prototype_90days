package com.takayuki.qe.tests;

import com.takayuki.qe.TestBase;
import com.takayuki.qe.pages.InventoryPage;
import com.takayuki.qe.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginSuccessTest extends TestBase {

  @Test
  void login_success_should_show_products() {
    LoginPage loginPage = new LoginPage(page);
    loginPage.open();

    // Sauce Demoの標準ユーザー
    loginPage.login("standard_user", "secret_sauce");

    InventoryPage inventoryPage = new InventoryPage(page);
    Assertions.assertEquals("Products", inventoryPage.getTitleText());
  }
}