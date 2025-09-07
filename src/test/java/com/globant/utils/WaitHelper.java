package com.globant.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    // Wait for visible element
    public WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for clickeable element
    public WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
