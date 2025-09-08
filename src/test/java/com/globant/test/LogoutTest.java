package com.globant.test;

import com.globant.base.BaseTest;
import com.globant.pages.AsideMenuPage;
import com.globant.pages.CartPage;
import com.globant.pages.InventoryPage;
import com.globant.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(com.globant.utils.TestListener.class)

public class LogoutTest extends BaseTest {
    private static final String BASE_URL = "https://www.saucedemo.com/";

    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private AsideMenuPage asideMenuPage;
    private LoginPage loginPage;

    @Parameters({"username", "password"})
    @BeforeMethod
    public void login(String username, String password) {
        driver.get(BASE_URL + LoginPage.LOGIN_URL);
        loginPage = new LoginPage(driver);
        inventoryPage = loginPage.loginSuccess(username, password);
    }

    @Test
    public void logoutFromInventoryPage() {
        loginPage = inventoryPage.getAsideMenuPage().logout();

        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }
}
