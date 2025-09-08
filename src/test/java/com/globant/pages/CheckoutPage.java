package com.globant.pages;

import com.globant.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;
    private WaitHelper wait;
    public static final String CHECKOUT_URL = "checkout-step-one.html";

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WaitHelper(driver);
    }

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        postalCodeField.sendKeys(postalCode);
    }

    public SecondCheckout clickContinueButton() {
        continueButton.click();
        return new SecondCheckout(driver);
    }

    public SecondCheckout enterFieldsAndContinue(String firstName, String lastName, String postalCode) {
        wait.waitForVisibility(firstNameField);
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
        continueButton.click();
        return new SecondCheckout(driver);
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    public boolean isErrorMessageDisplayed() {
        wait.waitForVisibility(errorMessage);
        return errorMessage.isDisplayed();
    }

    public String getErrorMessage() {
        wait.waitForVisibility(errorMessage);
        return errorMessage.getText();
    }


}
