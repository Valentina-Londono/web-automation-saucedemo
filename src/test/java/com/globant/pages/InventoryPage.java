package com.globant.pages;

import com.globant.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class InventoryPage {
    private WebDriver driver;
    private WaitHelper wait;
    public static final String INVENTORY_URL = "inventory.html";

    @FindBy(className = "title")
    private WebElement inventoryTitle;

    @FindBy(css = ".btn_inventory ")
    private List<WebElement> inventoryProductsButtons;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement inventoryRemoveButton;

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

    // Purchase a random product
    public void addProductToCart(){
        Random rand = new Random();
        int index = rand.nextInt(inventoryProductsButtons.size());
        inventoryProductsButtons.get(index).click();
    }

    public CartPage clickShoppingCartButton(){
        shoppingCartButton.click();
        return new CartPage(driver);
    }
}
