package com.globant.pages;

import com.globant.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
    private WebDriver driver;
    private WaitHelper wait;
    public static final String INVENTORY_URL = "inventory.html";

    @FindBy(className = "title")
    private WebElement inventoryTitle;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement inventoryProductButton;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartButton;


    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(this.driver);
        PageFactory.initElements(driver, this);
    }

    public String getInventoryTitle(){
        wait.waitForVisibility(inventoryTitle);
        return inventoryTitle.getText();
    }

    public void addProductToCart(){
        inventoryProductButton.click();
    }

    public CartPage clickShoppingCartButton(){
        shoppingCartButton.click();
        return new CartPage();
    }
}
