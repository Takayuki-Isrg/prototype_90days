package com.takayuki.qe.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.takayuki.qe.TestBase;
import com.takayuki.qe.pages.InventoryPage;
import com.takayuki.qe.pages.LoginPage;

public class LoginTest extends TestBase{

    @Test
    void login_success_should_show_products() {
      LoginPage loginPage = new LoginPage(page);
      loginPage.open();
  
      // Sauce Demoの標準ユーザー
      loginPage.login("standard_user", "secret_sauce");
  
      InventoryPage inventoryPage = new InventoryPage(page);
      Assertions.assertEquals("Products", inventoryPage.getTitleText());
    }

    @Test
    void login_fail_invalid_password_should_show_error(){
      LoginPage loginPage = new LoginPage(page);
      loginPage.open();
  
      loginPage.login("standard_user", "wrong_password");
  
      String error = loginPage.getErrorMessage();
      Assertions.assertTrue(error.contains("Username and password do not match"));
    }

    void login_fail_empty_credentials_should_show_error(){
      LoginPage loginPage = new LoginPage(page);
      loginPage.open();
  
      loginPage.login("", "");
  
      String error = loginPage.getErrorMessage();
      Assertions.assertTrue(error.contains("Username is required"));
    }
}
