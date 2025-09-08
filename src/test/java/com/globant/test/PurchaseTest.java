package com.globant.test;

import com.globant.base.BaseTest;
import com.globant.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(com.globant.utils.TestListener.class)

public class PurchaseTest extends BaseTest {

    private static final String BASE_URL = "https://www.saucedemo.com/";

    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private SecondCheckout secondCheckoutPage;
    private CheckoutComplete checkoutCompletePage;

    @Parameters({"username", "password"})
    @BeforeMethod
    public void login(String username, String password) {
        driver.get(BASE_URL + LoginPage.LOGIN_URL);
        LoginPage loginPage = new LoginPage(driver);
        inventoryPage = loginPage.loginSuccess(username, password);
    }

    @Parameters({"firstName", "lastName", "postalCode"})
    @Test
    public void purchaseProductsAndConfirm(String firstName, String lastName, String postalCode) {
        inventoryPage.addProductsToCart(1);
        cartPage = inventoryPage.clickShoppingCartButton();

        checkoutPage = cartPage.clickCheckoutButton();
        secondCheckoutPage = checkoutPage.enterFieldsAndContinue(firstName, lastName, postalCode);

        checkoutCompletePage = secondCheckoutPage.finishButtonClick();
        Assert.assertEquals(checkoutCompletePage.getOrderConfirmationMessage(), "Thank you for your order!" );
    }
}
