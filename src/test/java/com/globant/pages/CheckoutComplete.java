package com.globant.pages;

import com.globant.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutComplete {
    private WebDriver driver;
    public static final String CHECKOUT_COMPLETE_URL = "checkout-complete.html";

    @FindBy(css = "h2[data-test='complete-header']")
    private WebElement orderConfirmationMessage;

    @FindBy(id = "back-to-products")
    private WebElement backToProductsButton;

    public CheckoutComplete(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getOrderConfirmationMessage() {
        return orderConfirmationMessage.getText();
    }

    public void backToProductsButtonClick() {
        backToProductsButton.click();
    }
}
