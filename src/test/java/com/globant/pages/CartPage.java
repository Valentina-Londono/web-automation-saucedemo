package com.globant.pages;

import com.globant.utils.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    private WebDriver driver;
    public static final String CART_URL = "cart.html";

    @FindBy(css = ".cart_button")
    private List<WebElement> productsInCart;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void removeProductsFromCart(int quantity) {
        for (int i = 0; i < quantity; i++) {
            List<WebElement> currentCart = driver.findElements(By.cssSelector(".cart_button"));

            if (currentCart.isEmpty()) {
                break;
            }
            currentCart.get(0).click();
        }
    }


    public boolean checkCartIsEmpty(){
        return productsInCart.isEmpty();
    }

    public CheckoutPage clickCheckoutButton(){
        checkoutButton.click();
        return new CheckoutPage(driver);
    }

    public InventoryPage clickContinueShoppingButton(){
        continueShoppingButton.click();
        return new InventoryPage(driver);
    }
}
