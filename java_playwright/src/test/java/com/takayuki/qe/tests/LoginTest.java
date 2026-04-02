package com.takayuki.qe.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.takayuki.qe.TestBase;
import com.takayuki.qe.pages.InventoryPage;
import com.takayuki.qe.pages.LoginPage;

public class LoginTest extends TestBase{

    private LoginPage openLoginPage() {
      LoginPage loginPage = new LoginPage(page);
      loginPage.open();
      return loginPage;
    }

    @Test
    void login_success_should_show_products() {
      LoginPage loginPage = openLoginPage();
      
      // Sauce Demoの標準ユーザー
      loginPage.login("standard_user", "secret_sauce");
      
      InventoryPage inventoryPage = new InventoryPage(page);
      Assertions.assertEquals("ProductsXXX", inventoryPage.getTitleText());
    }
    
    @Test
    void login_fail_invalid_password_should_show_error(){
      LoginPage loginPage = openLoginPage();
      
      loginPage.login("standard_user", "wrong_password");
      
      Assertions.assertTrue(loginPage.isErrorDisplayed());
      Assertions.assertTrue(loginPage.hasErrorMessage("Epic sadface"));
    }
    
    @Test
    void login_fail_empty_credentials_should_show_error(){
      LoginPage loginPage = openLoginPage();
      
      loginPage.login("", "");
      
      Assertions.assertTrue(loginPage.isErrorDisplayed());
      Assertions.assertTrue(loginPage.hasErrorMessage("Username is required"));
    }
}
