package com.globant.pages;

import com.globant.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AsideMenuPage {
    private WebDriver driver;
    private WaitHelper wait;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement openMenuButton;

    @FindBy(id = "inventory_sidebar_link")
    private WebElement inventoryOptionButton;

    @FindBy(id = "about_sidebar_link")
    private WebElement aboutOptionButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutOptionButton;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetAppOptionButton;

    public AsideMenuPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public void openMenu() {
        openMenuButton.click();
    }

    public void openInventory() {
        wait.waitForVisibility(inventoryOptionButton);
        inventoryOptionButton.click();
    }

    public void openAbout() {
        wait.waitForVisibility(aboutOptionButton);
        aboutOptionButton.click();
    }

    public void openLogout() {
        wait.waitForVisibility(logoutOptionButton);
        logoutOptionButton.click();
    }

    public LoginPage logout() {
        openMenu();
        openLogout();
        return new LoginPage(driver);
    }

    public void resetApp() {
        wait.waitForVisibility(resetAppOptionButton);
        resetAppOptionButton.click();
    }
}