package com.globant.pages;

import com.globant.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecondCheckout {
    private WebDriver driver;
    public static final String SECOND_CHECKOUT_URL = "checkout-step-two.html";

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    public SecondCheckout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public InventoryPage cancelButtonClick() {
        cancelButton.click();
        return new InventoryPage(driver);
    }

    public CheckoutComplete finishButtonClick() {
        finishButton.click();
        return new CheckoutComplete(driver);
    }
}
