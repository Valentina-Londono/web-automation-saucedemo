package com.globant.pages;

import com.globant.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InventoryPage {
    private WebDriver driver;
    private WaitHelper wait;
    private AsideMenuPage asideMenuPage;
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
        this.asideMenuPage = new AsideMenuPage(this.driver);
        PageFactory.initElements(driver, this);
    }

    public AsideMenuPage getAsideMenuPage() {
        return asideMenuPage;
    }

    public String getInventoryTitle(){
        wait.waitForVisibility(inventoryTitle);
        return inventoryTitle.getText();
    }

    // Purchase a random products

    public void addProductsToCart(int quantity) {
        Random rand = new Random();
        List<WebElement> availableProducts = new ArrayList<>(inventoryProductsButtons);

        int total = Math.min(quantity, availableProducts.size());

        for (int i = 0; i < total && !availableProducts.isEmpty(); i++) {
            int index = rand.nextInt(availableProducts.size());
            availableProducts.get(index).click();
            availableProducts.remove(index);
        }
    }

    public CartPage clickShoppingCartButton(){
        shoppingCartButton.click();
        return new CartPage(driver);
    }
}
