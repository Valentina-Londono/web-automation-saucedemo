package com.globant.pages;

import com.globant.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    private WaitHelper wait;
    public static final String LOGIN_URL = "";

    @FindBy(id = "user-name")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginSubmitButton;

    @FindBy(css = "h3[data-test='error']")
    private WebElement loginErrorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        userNameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public InventoryPage clickLoginButton() {
        loginSubmitButton.click();
        return new InventoryPage(driver);
    }

    public boolean isLoginErrorMessageDisplayed() {
        wait.waitForVisibility(loginErrorMessage);
        return loginErrorMessage.isDisplayed();
    }

    public String getLoginErrorMessage() {
        wait.waitForVisibility(loginErrorMessage);
        return loginErrorMessage.getText();
    }
}
