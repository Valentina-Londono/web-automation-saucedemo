package com.globant.test;

import com.globant.base.BaseTest;
import com.globant.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(com.globant.utils.TestListener.class)

public class RemoveProductsTest extends BaseTest {
    private static final String BASE_URL = "https://www.saucedemo.com/";

    private InventoryPage inventoryPage;
    private CartPage cartPage;

    @Parameters({"username", "password"})
    @BeforeMethod
    public void login(String username, String password) {
        driver.get(BASE_URL + LoginPage.LOGIN_URL);
        LoginPage loginPage = new LoginPage(driver);
        inventoryPage = loginPage.loginSuccess(username, password);
    }

    @Test
    public void removeProductsFromCart() {
        inventoryPage.addProductsToCart(3);
        cartPage = inventoryPage.clickShoppingCartButton();

        cartPage.removeProductsFromCart(3);
        Assert.assertTrue(cartPage.checkCartIsEmpty());
    }
}
